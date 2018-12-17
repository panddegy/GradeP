package com.biz.grade.exec;

import com.biz.grade.service.GradeService;

public class GradeExec01 {
	
	public static void main(String[] args) {
		
		String stdFile="src/com/biz/grade/학생리스트.txt";
		String scoreFile="src/com/biz/grade/점수표.txt";
		String gradeFile="src/com/biz/grade/성적표정리.txt";
		String[] files= {stdFile,scoreFile,gradeFile};
		
		GradeService gs=new GradeService(files);
	
		gs.stdFileRead();
		gs.scoreFileToList();
		gs.stdMatchScore();
		gs.viewList();
		gs.writeScore();
	}

}
