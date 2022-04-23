package a.b.c.test.xml_p;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ReadXMLClass {
	public static final String XML_FILE_PATH="C:\\00.KOSMO108\\30.Web\\eclipse_web_yys\\eclipse_yys_work\\kosMember_YYS2\\WebContent\\kos_xml_p";
	public static void main(String args[]){
		String testClass="";
		try {
			Logger logger = LogManager.getLogger(ReadXMLClass.class);
			// Tomcat 서버에서 웹 서버(코요태) 위치에 있는 fileClass.xml 파일을
			// Tomcat 서버가 설치된 로컬 경로에 있는 물리적 파일 위치를 찾아서
			// java.io.File 객체로 읽어 오는 것이다.
			// java.io.File 객체를 물리적 경로를 읽는 객체이다.
			String xmlFilePath=ReadXMLClass.XML_FILE_PATH;
			logger.info("xmlFilePath >>> : "+xmlFilePath);
			// xmlFilePath >>> : C:\00.KOSMO108\30.Web\eclipse_web_yys\eclipse_yys_work\kosMember_YYS2\
			// WebContent\kos_xml_p
			 
			
			File fXmlFile=new File(xmlFilePath+"/fileClass.xml");
			logger.info("fXmlFile >>> : "+fXmlFile);
			// fXmlFile >>> : fXmlFile >>> : C:\00.KOSMO108\30.Web\eclipse_web_yys\eclipse_yys_work\kosMember_YYS2
			// \WebContent\kos_xml_p\fileClass.xml
			
			// 팩토리 디자인 패턴: 형식: xml파일을 읽어서 파싱
			// 물리적인 xml 파일을 xml 객체로 변환하기 위해서 팩토리 디자인 패턴을 이용한다.
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			/*
			 * javax.xml.parsers.DocumentButilderFactory 
			 * (abstract class)
			 * 
			 * Modifier and Type  :: Methods and Description
			 * static DocumentBuilderFactory ::  newInstance()
			 * 
			 *  Obtain a new instance of a DocumentBuilderFactory. 
			 *   This static method creates a new factory instance.
			 * */
			
			logger.info("dbFactory >>> : "+dbFactory);
			// 다시 실행해도 참조변수 주소값이 변하지 않는다.
			// dbFactory >>> : com.sun.org.apache.xerces.internal.jaxp.
			// DocumentBuilderFactoryImpl@179d3b25
			
			DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();
			/*
			 * javax.xml.parsers.DocumentBuilderFactory
			 * (abstract class)
			 * 
			 * Modifier and Type  :: Methods and Description
			 * abstract DocumentBuiler :: newDocumentBuilder()
			 * 
			 * Creates a new instance of a DocumentBuilder using 
			 * the currently configured parameters.
			 * */
			
			logger.info("dBuilder >>> : "+dBuilder);
			// 다시 실행해도 참조변수 주소값이 변하지 않는다.
			// dBuilder >>> : com.sun.org.apache.xerces.internal.
			// jaxp.DocumentBuilderImpl@254989ff
			
			// parse() 함수가 물리적인 xml 파일을 파싱해서 메모리에 xml 객체로 변환시킨다.
			Document doc=dBuilder.parse(fXmlFile);
			/*
			 * javax.xml.parsers.DocumentBuilder
			 * (abstract class)
			 * 
			 * .parse(File f)
			 * Modifier and Type  :: Methods and Description
			 * Document :: parse(File f)
			 * 
			 * Parse the content of the given file as an XML document 
			 * and return a new DOM Document object.
			 * */
			
			
			logger.info("doc >> : "+doc);
			// doc >> : [#document: null]
			
			// xml 문서를 깨끗하게 만드세요
			doc.getDocumentElement().normalize();
			logger.info("doc >>> : "+doc);
			// doc >>> : [#document: null]
			
			/*
			 * org.w3c.dom.Document
			 * 
			 *.getDocumentElement()
			 * Modifier and Type  :: Methods and Description
			 * Element :: getDocumentElement()
			 * 
			 * This is a convenience attribute that allows direct access to the child node 
			 * that is the document element of the document.
			 * 문서의 문서 요소인 하위 노드에 직접 액세스할 수 있는 편리성 속성입니다.
			 * 
			 * org.w3c.dom.Element
			 * public interface Element extends Node
			 * 
			 * org.w3c.dom.Node
			 * 
			 * .normalize
			 * Modifier and Type  :: Methods and Description
			 * void :: normalize()
			 * 
			 * Puts all Text nodes in the full depth of the sub-tree underneath this Node, 
			 * including attribute nodes, into a "normal" form where only structure 
			 * (e.g., elements, comments, processing instructions, CDATA sections,
			 *  and entity references) separates Text nodes, i.e., 
			 *  there are neither adjacent Text nodes nor empty Text nodes.
			 * 
			 * 속성 노드를 포함하여 하위 트리의 전체 깊이에 있는 모든 텍스트 노드를 구조
			 * (예: 요소, 주석, 처리 지침, CDATA 섹션 및 도면요소 참조)만 텍스트 노드를 분리하는 
			 * "정상" 형태로 만듭니다. 즉, 인접한 텍스트 노드나 빈 텍스트 노드가 없습니다.
			 * */
			
			logger.info("Root element : "+doc.getDocumentElement().getNodeName());
			// Root element : ROOT
			
			/*
			 * org.w3c.dom.Node
			 * 
			 * .normalize
			 * Modifier and Type  :: Methods and Description
			 * String :: getNodeName()
			 * 
			 * The name of this node, depending on its type; see the table above.
			 * */
			NodeList nList=doc.getElementsByTagName("testclass");
			System.out.println("--------------------");
			/* doc는 Document의 참조변수이다.
			 * org.w3c.dom.Document
			 *
			 * .getElementsByTagName(String elementId)
			 * Modifier and Type  :: Methods and Description
			 * NodeList :: .getElementsByTagName(String elementId)
			 * Returns the Element that has an ID attribute with the given value.
			*/ 
			
			logger.info("nList.getLenth() >>> : "+nList.getLength());
			//  nList.getLenth() >>> : 1
			
			for(int temp=0; temp<nList.getLength(); temp++){
				/* org.w3c.dom.NodeList
				 * .getLength()
				 * 
				 * Modifier and Type  :: Methods and Description
				 * int :: getLength()
				 * 
				 * The number of nodes in the list. 
				 * The range of valid child node indices is 0 to length-1 inclusive.
				 * 목록에 있는 노드 수입니다. 유효한 하위 노드 인덱스 범위는 0 ~ 길이 1입니다.
				 * */
				 
				Node nNode=nList.item(temp);
				/*
				 * org.w3c.dom.NodeList
				 * .item(int index)
				 * 
				 * Modifier and Type  :: Methods and Description
				 * Node :: item(int index)
				 * Returns the indexth item in the collection.
				 * */
				logger.info(temp+"번째 nNode >>> : "+nNode);
				//  0번째 nNode >>> : [testclass: null]
				logger.info("nNode.getNodeType() >>> : "+nNode.getNodeType());
				// nNode.getNodeType() >>> : 1
				logger.info("Node.ELEMENT_NODE >>> : "+Node.ELEMENT_NODE);
				// Node.ELEMENT_NODE >>> : 1
				if(nNode.getNodeType()==Node.ELEMENT_NODE) {
					/*
					 * 
					 * org.w3c.dom.Node
					 * .getNodeType
					 * Modifier and Type  :: Methods and Description
					 * short :: getNodeType()
					 * A code representing the type of the underlying object, 
					 * as defined above.
					 * 
					 * org.w3c.dom.Node
					 * 
					 * Fields
					 * static short :: ELEMENT_NODE
					 * The node is an Element
					 * 
					 * Constant Field Values
					 * org.w3c.dom.Node
					 * 
					 * public static final short ELEMENT_NODE :: 1
					 * 
					 * */
					
					Element eElement = (Element) nNode;
					/*
					 * org.w3c.dom.Node
					 * 
					 * All known Subinterfaces
					 * 
					 * ......Elemnet.....
					 * 
					 * 
					 * Node 클래스의 참조변수를 클래스 다운캐스팅을 통해
					 * Element의 참조변수로 선언
					 * 
					 * */
					
					
					testClass = getTagValue("test", eElement);
					System.out.println("test : "+testClass);
					// test : a.b.c.test.xml.TestClass
				}
			}
			
			try {
				Class cla_1=Class.forName(testClass);
				logger.info("Class cla_1 >>> : "+cla_1);
				// Class cla_1 >>> : class a.b.c.test.xml.TestClass
				
				TestClass classAction=(TestClass)cla_1.newInstance();
				/*
				 * java.lang.Class Class<T>
				 * T - the type of the class modeled by this Class object.
				 * 
				 * .newInstance()
				 * Modifier and Type	Method and Description
				 * T :: newInstance()
				 * 
				 * Returns:
				 * a newly allocated instance of the class represented by this object.
				 * 
				 * */
				
				System.out.println("classAction >>> : "+classAction);
				// classAction >>> : a.b.c.test.xml_p.TestClass@5d099f62
				classAction.test();
				// a.b.c.test.xml_p.TestClass에 있는 test 함수안의 내용이 출력된다.
			}catch(Exception e){}
			
			// catch(ClassNotFoundException e){}
			// catch(InstantiationException i){}
			// catch(IllegalAccessException i1){}
			
		}catch(Exception e){
			System.out.println(e);
		}
	} // end of main
	
	private static String getTagValue(String sTag, Element eElement){
		Logger logger = LogManager.getLogger(ReadXMLClass.class);
		logger.info("getTagValue 함수 진입 >>> : ");
		// getTagValue 함수 진입 >>> :
		logger.info("String sTag >> : "+sTag);
		// String sTag >> : test
		logger.info("Element eElement >>> : "+eElement);
		//   Element eElement >>> : [testclass: null]

		NodeList n1List=eElement.getElementsByTagName(sTag).item(0).getChildNodes();
		/*
		 * org.w3c.dom.Element
		 * .getElementByTagName(String name)
		 * 
		 * Modifier and Type  :: Methods and Description
		 * NodeList :: getElementsByTagName(String name)
		 * 
		 * org.w3c.dom.NodeList
		 * .item(int index)
		 * 
		 * Modifier and Type  :: Methods and Description
		 * Node :: item(int index)
		 * Returns the indexth item in the collection.
		 * 
		 * org.w3c.dom.Node
		 * .getChildNodes()
		 * 
		 * Modifier and Type  :: Methods and Description
		 * NodeList :: getChildNodes()
		 * A NodeList that contains all children of this node. 
		 * If there are no children, this is a NodeList containing no nodes.
		 * */
		Node nValue=(Node) n1List.item(0);
		/*
		 *n1List는 NodeList의 참조변수이다.
		 * Nodelist의 item함수를 쓰면
		 * 
		 * The node at the indexth position in the NodeList, 
		 * or null if that is not a valid index.
		 * (Node) 를 굳이 써야할 필요는 모르겠지만, return 형을 맞춰준다는 것이 포인트인 듯 하다.
		 * */
		return nValue.getNodeValue();
		/*
		 * org.w3c.dom.Node
		 * 
		 * .getNodeValue()
		 * Modifier and Type  :: Methods and Description
		 * String :: getNodeValue()
		 * 
		 * The value of this node, depending on its type; see the table above.
		 *  When it is defined to be null, setting it has no effect, 
		 *  including if the node is read-only.
		 * */
	}
} // end of ReadXMLClass
