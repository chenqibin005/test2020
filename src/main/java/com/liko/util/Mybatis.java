package com.liko.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resources;
import java.io.InputStream;

/**
 * @author hangzhi1063
 * @date 2020/8/25 13:35
 */
public class Mybatis {
   private static SqlSessionFactory factory= null;
    static {
        String config ="/mybatis.xml";
        InputStream in=Resources.class.getResourceAsStream(config);
        SqlSessionFactoryBuilder builder =new SqlSessionFactoryBuilder();
        factory=builder.build(in);
    }

    public static SqlSession getSqlSession(){
        SqlSession sqlSession =null;
        if (factory!=null){
            sqlSession = factory.openSession();//非自动提交事务

        }
        return sqlSession;
    }

}
