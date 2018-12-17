package com.biz.grade.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.biz.grade.contact.GradeContact;
import com.biz.grade.vo.GradeVO;

public class GradeService {
	
	String stdFile;
	String scoreFile;
	String gradeFile;
	List<GradeVO> gradeList;
	List<GradeVO> scoreList;
	
	public GradeService(String[] files) {
		
		gradeList=new ArrayList<>();
		scoreList=new ArrayList<>();
		this.stdFile=files[GradeContact.FILES_STD];
		this.scoreFile=files[GradeContact.FILES_SCORE];
		this.gradeFile=files[GradeContact.FILES_GRADE];
	}
	
	public void writeScore(){
		
		PrintWriter pw;
		
		try {
			pw=new PrintWriter(gradeFile);
			for(GradeVO vo:gradeList) {
				pw.print(vo.getStrNum()+":");
				pw.print(vo.getStrName()+":");
				pw.print(vo.getStrtel()+":");
				pw.print(vo.getStrAddr()+":");
				pw.print(vo.getIntKor()+":");
				pw.print(vo.getIntEng()+":");
				pw.print(vo.getIntMath()+":");
				pw.print(vo.getIntSum()+":");
				pw.printf("%3.2f\r\n",vo.getFloatAvg());
			}
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void viewList() {
		
		System.out.println("===========================================================================");
		System.out.println("학번\t이름\t전화번호\t주소\t국어\t영어\t수학\t총점\t평균");
		System.out.println("===========================================================================");
		for(GradeVO vo : gradeList) {
			System.out.printf("%3s\t%-8.8s\t%-15.15s\t%-10.10s\t%3d%3d%3d%4d%4.2f\n"
					,vo.getStrNum(),vo.getStrName(),vo.getStrtel(),vo.getStrAddr(),vo.getIntKor()
					,vo.getIntEng(),vo.getIntMath(),vo.getIntSum(),vo.getFloatAvg());
		}
	}
	
	public void stdMatchScore() {
		
		for(GradeVO vo:scoreList) {
			String strNum=vo.getStrNum();
			for(GradeVO gr:gradeList) {
				if(gr.getStrNum().equals(strNum)) {
					gr.setIntKor(vo.getIntKor());
					gr.setIntEng(vo.getIntEng());
					gr.setIntMath(vo.getIntMath());
					gr.setIntSum(vo.getIntSum());
					gr.setFloatAvg(vo.getFloatAvg());
				}
			}
		}
	}
	
	public void scoreFileToList() {
		
		FileReader fr;
		BufferedReader buffer;
		
		try {
			fr=new FileReader(scoreFile);
			buffer=new BufferedReader(fr);
			while(true) {
				String read=buffer.readLine();
				if(read==null) break;
				String[] readArr=read.split(":");
				GradeVO vo=new GradeVO();
				int intKor=Integer.valueOf(readArr[GradeContact.SC_intKor]);
				int intEng=Integer.valueOf(readArr[GradeContact.SC_intEng]);
				int intMath=Integer.valueOf(readArr[GradeContact.SC_intMath]);
				int intSum=intKor+intEng+intMath;
				float floatAvg=intSum/3.0f;
				vo.setStrNum(readArr[GradeContact.SC_strNum]);
				vo.setIntKor(intKor);
				vo.setIntEng(intEng);
				vo.setIntMath(intMath);
				vo.setIntSum(intSum);
				vo.setFloatAvg(floatAvg);
				scoreList.add(vo);
			}
			buffer.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void stdFileRead() {
		
		FileReader fr;
		BufferedReader buffer;
		
		try {
			fr=new FileReader(stdFile);
			buffer=new BufferedReader(fr);
			while(true) {
				String read=buffer.readLine();
				if(read==null) break;
				String[] readArr=read.split(":");
				GradeVO vo=new GradeVO();
				vo.setStrNum(readArr[GradeContact.ST_strNum]);
				vo.setStrName(readArr[GradeContact.ST_strName]);
				vo.setStrtel(readArr[GradeContact.ST_strtel]);
				vo.setStrAddr(readArr[GradeContact.ST_strAddr]);
				gradeList.add(vo);
			}
			buffer.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void scoreFileRead() {
		
		FileReader fr;
		BufferedReader buffer;
		
		try {
			fr=new FileReader(scoreFile);
			buffer=new BufferedReader(fr);
			while(true) {
				String read=buffer.readLine();
				if(read==null) break;
				String[] readArr=read.split(":");
				for(GradeVO vo:gradeList) {
					if(vo.getStrNum().equals(readArr[0])) {
						int intKor=Integer.valueOf(readArr[1]);
						int intEng=Integer.valueOf(readArr[2]);
						int intMath=Integer.valueOf(readArr[3]);
						int intSum=intKor+intEng+intMath;
						float floatAvg=intSum/3.0f;
						vo.setIntKor(intKor);
						vo.setIntEng(intEng);
						vo.setIntMath(intMath);
						vo.setIntSum(intSum);
						vo.setFloatAvg(floatAvg);
					}
				}
			}
			buffer.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

}


















