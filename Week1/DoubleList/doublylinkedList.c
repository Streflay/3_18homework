#define _CRT_SECURE_NO_WARNINGS 1

#include<stdio.h>
#include<string.h>
#include<stdlib.h>

typedef struct LinkNode
{
	//char name[20];
	int data;//ֵ
	struct LinkNode* prev;
	struct LinkNode* next;
}Node;


//���ڱ��ڵ�
Node* head;
Node* tail;

//����
void DoubleLinkedListSentine() {
	head = (Node*)malloc(sizeof(Node));
	head->data = 23;
	head->prev = NULL;
	tail= (Node*)malloc(sizeof(Node));
	tail->data = 23;
	tail->next = NULL;
	head->next = tail;
	tail->prev = head;
}

//����
Node* findnode(int index) {
	int i = -1;
	for (Node* p = head; p != tail; p = p->next, i++) {
		if (i == index) {
			return p;
		}
	}
	printf("���ҵ����ݲ�����");
	return NULL;
}

void insert(int index, int value) {
	Node* prev = findnode(index-1);
	if (prev == NULL) {
		printf("ָ�������쳣");
		return;
	}
	Node* next = prev->next;
	Node* insert= (Node*)malloc(sizeof(Node));
	insert->prev = prev;
	insert->next = next;
	insert->data = value;
	prev->next = insert;
	next->prev = insert;
}

void remove0(int index) {
	Node* prev=findnode(index - 1);
	if (prev == NULL) {
		printf("ָ�������쳣");
		return;
	}
	Node* removed = prev->next;
	if (removed == tail) {
		printf("ָ�������쳣");
		return;
	}
	Node* next = removed->next;
	prev->next = next;
	next->prev = prev;
}

void DestroyLink(Node* head)
{
	if (head->next == NULL)
	{
		return;
	}
	Node* p = head;
	while (p->next != NULL&& p!=tail)
	{
		Node* s = p->next;
		free(p);
		p = s;
	}
	head = NULL;
	tail = NULL;
}

void display(Node* head) {
	Node* p = head->next;
	while (p != tail) {
		printf("%d ", p->data);
		p = p->next;
	}
	printf("\n");
}

void addFirst(int value) {
	insert(0, value);
}

void addlast(int value) {
	Node* last = tail->prev;
	Node *add= (Node*)malloc(sizeof(Node));
	add->prev = last;
	add->next = tail;
	add->data = value;
	last->next = add;
	tail->prev = add;
}


void menu()
{
	printf("*********************************\n");
	printf("******��A��  �˳�����   *********\n");
	printf("******��B��  ��������   *********\n");
	printf("******��C��  ��ʾ����   *********\n");
	printf("******��D��  ��ѯ����   *********\n");
	printf("******��E��  ɾ������   *********\n");
	printf("******��F��  �������   *********\n");
	printf("******��G��  ��������   *********\n");
	printf("******��H��  ��������   *********\n");
	printf("*********************************\n");
}

int main()
{
	char input = 0;
	do
	{
		menu();
		printf("��ѡ��:>");
		scanf("%c", &input);
		switch (input) {
		case 'a':
			exit(0);
		case 'b':
			DoubleLinkedListSentine();
			getchar();
			break;
		case 'c':
			display(head);
			getchar();
			break;
		case 'd':
			printf("����������ҵ���ţ�");
			int i = 0;
			scanf("%d", &i);
			Node*x=findnode(i);
			printf("%d ", x->data);
			getchar();
			break;
		case 'e':
			printf("��������ɾ������ţ�");
			int j = 0;
			scanf("%d", &j);
			remove0(j);
			getchar();
			break;
		case 'f':
			printf("����������ӵ�ֵ��");
			int value = 0;
			scanf("%d", &value);
			if (head->next == tail)
			{
				addFirst(value);
			}
			else {
				addlast(value);
			}
			getchar();
			break;
		case 'g':
			DestroyLink(head);
			break;
		case 'h':
			printf("��������������ţ�");
			int k, value1;
			scanf("%d", &k);
			printf("������������ֵ��");
			scanf("%d", &value1);
			insert(k, value1);
			break;
		}
		printf("\n\n");
	} while (1);
}





