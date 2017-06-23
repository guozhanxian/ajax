package com.ralph.web;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.ralph.domain.Stud;

public class XmlTest
{

	public static void main(String[] args) throws Exception
	{
		File file = new File("test.xml");
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser sap = spf.newSAXParser();
		
		MyHandler h = new MyHandler();
		sap.parse(file, h);
		
		List<Stud> list = h.getList();
		for(Stud s:list)
		{
			System.out.println(s.getId()+"<<<"+s.getName()+"<<<"+s.getAge()+"<<<"+s.getMajor());
		}
	}

	static class MyHandler extends DefaultHandler
	{
		private List<Stud> list = new ArrayList<Stud>();
		
		private Stud stud;
		
		private String sss;

		public List<Stud> getList()
		{
			return list;
		}
		
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
		{
			if("student".equals(qName))
			{
				stud = new Stud();
				String id = attributes.getValue(0);
				stud.setId(Integer.parseInt(id));
			}
		}
		
		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException
		{
			if("name".equals(qName))
			{
				stud.setName(sss);
			}else if("age".equals(qName)){
				stud.setAge(Integer.parseInt(sss));
			}else if("major".equals(qName)){
				stud.setMajor(sss);
			}else if("student".equals(qName)){
				list.add(stud);
			}
		}
		
		@Override
		public void characters(char[] ch, int start, int length) throws SAXException
		{
			sss = new String(ch,start,length);
		}
	}
}
