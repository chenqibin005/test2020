package com.liko.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author hangzhi1063
 * @date 2020/8/25 18:57
 */
public class test01 {
    private static SqlSessionFactory factory =null;
    static {
        String cofig="mybatis.xml";
        try {
            InputStream in = Resources.getResourceAsStream(cofig);
            SqlSessionFactoryBuilder builder =new SqlSessionFactoryBuilder();
            factory = builder.build(in);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static SqlSession getSqlSession(){
        SqlSession sqlSession =null;
        if (factory!=null){
            sqlSession =factory.openSession();
        }
        return sqlSession;
    }
}
