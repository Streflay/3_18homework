#define _CRT_SECURE_NO_WARNINGS 1

#include<stdio.h>
#include<string.h>
#include<stdlib.h>


struct node
{
	char name[20];
	int data; 
	struct node* next;
};

char* s_gets(char* st, int n)
{
	char* ret;
	char* find;
	ret = fgets(st, n, stdin);
	if (ret) {
		find = strchr(st, '\n');
		if (find)
			*find = '\0';
		else
			while (getchar() != '\n')
				continue;
	}
	return ret;
}

struct node* getstrings(struct node* head)
{
	char input[20] = { 0 };
	struct node* prev = { 0 }, * current;
	puts("Enter the first strlen:");
	while (s_gets(input, 20) != NULL && input[0] != '\0')
	{
		current = (struct node*)malloc(sizeof(struct node));
		if (head == NULL)
		{
			head = current;
		}
		else
			prev->next = current;
		current->next = NULL;
		strcpy(current->name, input);
		puts("Enter your data:");
		scanf("%d", &current->data);
		while (getchar() != '\n')
		{
			continue;
		}
		puts("Enter next strlen(empty line to stop):");
		prev = current;
	}
	return head;
}

void printstring(struct node* head)
{
	struct node* current = { 0 };
	if (head == NULL)
	{
		printf("No data enter.");
	}
	else
		printf("Here is the strlen list:\n");
	current = head;
	while (current != NULL)
	{
		printf("Name : %-10s\t   Data : %d\n", current->name, current->data);
		current = current->next;
	}
	while (current != NULL)
	{
		head = current->next;
		free(current);
		current = head;
	}
}

int checkstring(struct node* head, char* str)
{
	struct node* current = { 0 };
	if (head == NULL)
	{
		return 0;
	}
	current = head;
	while (current != NULL)
	{
		if (strcmp(current->name, str) == 0)
		{
			printf("找到了: %s\n", current->name);
			return 1;
		}
		current = current->next;
	}
	return 0;
}

void savetofile(struct node* head, char* filename)
{
	struct node* current = { 0 };
	FILE* pfwrite = fopen(filename, "wb");
	if (pfwrite == NULL)
	{
		perror(savetofile);
	}
	current = head;
	while (current != NULL)
	{
		fwrite(current, sizeof(struct node), 1, pfwrite);
		current = current->next;
	}
	fclose(pfwrite);
	pfwrite = NULL;
}


struct node* Add(struct node* head, struct node* newnode)
{
	struct node* p = head;
	if (head == NULL)
	{
		head = newnode;
		newnode->next = NULL;
		return head;
	}
	while (p->next != NULL)
	{
		p = p->next;
	}
	p->next = newnode;
	newnode->next = NULL;
	return head;
}

struct node* getfromfile(struct node* head, char* filename)
{
	FILE* pfread = fopen(filename, "rb");
	struct node* p;
	if (pfread == NULL)
	{
		printf("Open the file error\n");
		system("pause");
		return head;
	}
	p = (struct node*)malloc(sizeof(struct node));
	while ((fread(p, sizeof(struct node), 1, pfread)) == 1)
	{
		head = Add(head, p);
		p = (struct node*)malloc(sizeof(struct node));
	}
	fclose(pfread);
	return head;
}

void DestroyLink(struct node* head)
{
	if (head == NULL)
	{
		return;
	}
	struct node* p = head->next;
	while (p->next != NULL)
	{
		struct node* s = p->next;
		free(p);
		p = s;
	}
	head = NULL;
}


void menu()
{
	printf("*********************************\n");
	printf("******【A】  退出程序   *********\n");
	printf("******【B】  创建链表   *********\n");
	printf("******【C】  显示链表   *********\n");
	printf("******【D】  查询链表   *********\n");
	printf("******【E】  保存文件   *********\n");
	printf("******【F】  添加链表   *********\n");
	printf("******【G】  销毁链表   *********\n");
	printf("*********************************\n");
}

int main()
{
	struct node* Link = { 0 };
	char input = 0;
	do
	{
		menu();
		printf("请选择:>");
		scanf("%c", &input);
		switch (input)
		{
		case 'a':
			exit(-1);
			break;
		case 'c':
			printstring(Link);
			getchar();
			break;
		case 'e':
			savetofile(Link, "homework.4.txt");
			printf("保存成功\n");
			getchar();
			break;
		case 'f':
			getfromfile(Link, "homework.4.txt");
			printf("添加成功\n");
			getchar();
			break;
		case 'g':
			DestroyLink(Link);
			break;
		}
		
		if (input == 'b')
		{
			getchar();
			Link = getstrings(NULL);
		}
		if (input == 'd')
		{
			getchar();
			char a[100] = { 0 };
			scanf("%s", a);
			int ret = checkstring(Link, a);
			if (ret == 0)
			{
				printf("查询不到\n");
			}
			getchar();
		}
		
	} while (1);
	printf("Bye!\n");
	return 0;
}