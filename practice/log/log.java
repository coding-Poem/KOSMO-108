Select�ڽ��� �α׸� ���� ��

getElementById[id] : Select�� ���� �Ӽ��� ������, length property�� ����� �� �� ������ ����

getElementsByname[name] : �ش� name�� ������ elements�� �� �� �����ϴ°��� ������ 
						   name�� ������ �̸��� �� �� �־, �� ��°�� ���� name���� ������� �Ѵ�.
						   Ư�� name�� ������ elements�� �� ���� ���� �������� ������ [] ó���� �������
						   cf) mhpname_0=mhpname[0], mhpname = document.getElementsByname("mhp");

document.memForm.mhp : Ȯ���ϰ� �׳��� ����. */





����
1. �ߺ��Ǵ� id�� ������ ���, document.getElementById([id])�� �� ��� value�� id�� ������ �±��� �� ��ŭ ���͹���.(���� value�� �ƴ�)



@@document.memForm.mhp ���� //�̰� id�ε� �νĵǰ� name���ε� �ν��̵ǳ�? ���� �´°��� �𸣰ھ�, �ϴ� mhp�� �ִ� ��� �� �θ�
4mem_byname.html
(Select�ڽ��� 1�� �� ��)
var mhp = document.memForm.mhp; 
//[object HTMLSelectElement]
var mhp_length = mhp.length;
//mhp_length >>> : 4
=======================================
(Select�ڽ��� 2 �� �� ��)
var mhp = document.memForm.mhp;
//[object RadioNodeList] <<<��ȭ
var mhp_length = mhp.length;
//mhp_length >>> : 2 <<<��ȭ 
=======================================
(Select �ڽ��� 3�� �� �� )
var mhp = document.memForm.mhp;
//[object RadioNodeList] == ����
var mhp_length = mhp.length;
//mhp_length >>> : 3 <<<��ȭ

��� 
1. document.memFrom.mhp ��ü�� ��ȭ
	-HTMLSelectElement�� ���� length �ʵ尡 ������ value�� ���� ��Ÿ����(4)
	-RaidoNodeList�� ���� mhp�� ������ ��ü node�� ���� ���δ�???(2,3)


@@id	document.getElementById("mhp");
(id="mhp"�� ����Ʈ�ڽ��� 1���� ��)
var mhp_id = document.getElementById("mhp"); 
	//mhp_id >>> : [object HTMLSelectElement]
var mhpid_length = mhp.length;
	//mhpid_length >>> : 4
========================================================
(id="mhp"�� ����Ʈ�ڽ��� 1��, name="mhp"�� ����Ʈ�ڽ��� 1��)
var mhp_id = document.getElementById("mhp"); 
	//mhp_id >>> : [object HTMLSelectElement]
var mhpid_length = mhp.length;
	//mhpid_length >>> : 4
=========================================================
(id="mhp"�� ����Ʈ�ڽ��� 1�� / name="mhp", id="mhp000"�� ����Ʈ�ڽ��� 1��)
���� ���� 
=========================================================



@@name	document.getElementsByName("mhp"); ����, ������ name�� ����.
(����Ʈ�ڽ��� 1�� �� ��)
var mhp_name = document.getElementsByName("mhp"); 
//[object NodeList]
var mhpname_length = mhp_name.length;
//mhpname_length >>> : 1
=========================================
(����Ʈ�ڽ��� 2�� �� ��)
var mhp_name = document.getElementsByName("mhp"); 
//[object NodeList]
var mhpname_length = mhp_name.length;
//mhpname_length >>> : 2
==========================================
(����Ʈ�ڽ��� 3�� �� ��)
var mhp_name = document.getElementsByName("mhp"); 
//[object NodeList]
var mhpname_length = mhp_name.length;
//mhpname_length >>> : 2

���.
1. getElementsByName()���� ������ <select>�� �����±װ� �ƴ϶�, <select>��ü�� �޴´�?? //([object NodeList])????
2. getElementsByName()���� ������ length �ʵ� ��� �� ������ name�� ���� �±��� ������ ����.(����)










============================================
var name = getElementsByname[name] 
name.length : �ش� name�� ������ �±װ� �� ������ ������ 

var name0 = name[0];
name0.length : �ش� name�� ������ �±� �� index 0�� °�� �±��� ���� �±װ� �� ������ ������
============================================
