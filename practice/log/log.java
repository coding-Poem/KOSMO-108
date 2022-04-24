Select박스의 로그를 찍을 때

getElementById[id] : Select의 하위 속성을 가져와, length property로 찍었을 때 총 개수가 나옴

getElementsByname[name] : 해당 name을 가지는 elements가 몇 개 존재하는가를 보여줌 
						   name은 동일한 이름이 올 수 있어서, 몇 번째에 오는 name인지 밝혀줘야 한다.
						   특정 name을 가지는 elements가 몇 개의 값을 가지는지 보려면 [] 처리를 해줘야함
						   cf) mhpname_0=mhpname[0], mhpname = document.getElementsByname("mhp");

document.memForm.mhp : 확실하게 그놈을 지정. */





선행
1. 중복되는 id가 존재할 경우, document.getElementById([id])를 할 경우 value가 id를 가지는 태그의 수 만큼 나와버림.(실제 value가 아님)



@@document.memForm.mhp 형식 //이거 id로도 인식되고 name으로도 인식이되네? 뭐가 맞는건지 모르겠어, 일단 mhp가 있는 놈들 다 부름
4mem_byname.html
(Select박스가 1개 일 때)
var mhp = document.memForm.mhp; 
//[object HTMLSelectElement]
var mhp_length = mhp.length;
//mhp_length >>> : 4
=======================================
(Select박스가 2 개 일 때)
var mhp = document.memForm.mhp;
//[object RadioNodeList] <<<변화
var mhp_length = mhp.length;
//mhp_length >>> : 2 <<<변화 
=======================================
(Select 박스가 3개 일 때 )
var mhp = document.memForm.mhp;
//[object RadioNodeList] == 동일
var mhp_length = mhp.length;
//mhp_length >>> : 3 <<<변화

결론 
1. document.memFrom.mhp 객체가 변화
	-HTMLSelectElement일 때는 length 필드가 가지는 value의 수를 나타낸다(4)
	-RaidoNodeList일 때는 mhp를 가지는 전체 node의 수를 보인다???(2,3)


@@id	document.getElementById("mhp");
(id="mhp"인 셀렉트박스가 1개일 때)
var mhp_id = document.getElementById("mhp"); 
	//mhp_id >>> : [object HTMLSelectElement]
var mhpid_length = mhp.length;
	//mhpid_length >>> : 4
========================================================
(id="mhp"인 셀렉트박스가 1개, name="mhp"인 셀렉트박스가 1개)
var mhp_id = document.getElementById("mhp"); 
	//mhp_id >>> : [object HTMLSelectElement]
var mhpid_length = mhp.length;
	//mhpid_length >>> : 4
=========================================================
(id="mhp"인 셀렉트박스가 1개 / name="mhp", id="mhp000"인 셀렉트박스가 1개)
위와 동일 
=========================================================



@@name	document.getElementsByName("mhp"); 형식, 동일한 name을 같는.
(셀렉트박스가 1개 일 때)
var mhp_name = document.getElementsByName("mhp"); 
//[object NodeList]
var mhpname_length = mhp_name.length;
//mhpname_length >>> : 1
=========================================
(셀렉트박스가 2개 일 때)
var mhp_name = document.getElementsByName("mhp"); 
//[object NodeList]
var mhpname_length = mhp_name.length;
//mhpname_length >>> : 2
==========================================
(셀렉트박스가 3개 일 때)
var mhp_name = document.getElementsByName("mhp"); 
//[object NodeList]
var mhpname_length = mhp_name.length;
//mhpname_length >>> : 2

결론.
1. getElementsByName()으로 받으면 <select>의 하위태그가 아니라, <select>객체를 받는다?? //([object NodeList])????
2. getElementsByName()으로 받으면 length 필드 사용 시 동일한 name을 같는 태그의 갯수를 샌다.(길이)










============================================
var name = getElementsByname[name] 
name.length : 해당 name을 가지는 태그가 몇 개인지 보여줌 

var name0 = name[0];
name0.length : 해당 name을 가지는 태그 중 index 0번 째인 태그의 하위 태그가 몇 개인지 보여줌
============================================
