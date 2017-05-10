package com.yihaomen.test;

import org.mybatis.generator.ant.GeneratorAntTask;

public class GenOracleMain {
	
	public static void main(String[] args) {
	    try {
	      GeneratorAntTask task = new GeneratorAntTask();
	      String genCfg = "D:/Workspaces_zhd/myBatisGenerator/src/mbgConfigurationoracle.xml";
	      task.setConfigfile(genCfg);  
	      task.execute();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }

}
