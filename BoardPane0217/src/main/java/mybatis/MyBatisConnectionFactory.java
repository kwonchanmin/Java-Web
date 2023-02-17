package mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConnectionFactory {
	
	private static SqlSessionFactory sqlSessionFactory;

	static {

		// 공장을 만들 때 필요한 XML 설정파일
		String resource = "./SqlMapConfig.xml";
		try {
			Reader reader = Resources.getResourceAsReader(resource);

			if (sqlSessionFactory == null) {
				// XML 설정을 이용해서 공장객체를 만든다.
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
