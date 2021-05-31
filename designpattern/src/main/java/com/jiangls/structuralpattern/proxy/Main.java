package com.jiangls.structuralpattern.proxy;

import structuralpattern.proxy.pool.LazyDataSource;
import structuralpattern.proxy.pool.PooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;


/**
 * App entry for Maven project.
 */
public class Main {

	public static void main(String[] args) throws Exception {
		DataSource lazyDataSource = new LazyDataSource(jdbcUrl, jdbcUsername, jdbcPassword);
		System.out.println("get lazy connection...");
		try (Connection conn1 = lazyDataSource.getConnection()) {
			// 并没有实际打开真正的Connection
		}
		System.out.println("get lazy connection...");
		try (Connection conn2 = lazyDataSource.getConnection()) {
			try (PreparedStatement ps = conn2.prepareStatement("SELECT * FROM students")) { // 打开了真正的Connection
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						System.out.println(rs.getString("name"));
					}
				}
			}
		}

		//使用连接池的时候，我们更希望能重复使用连接。如果调用方编写这样的代码：
        //调用方并不关心是否复用了Connection，但从PooledDataSource获取的Connection确实自带这个优化功能。如何实现可复用Connection的连接池？答案仍然是使用代理模式。
		DataSource pooledDataSource = new PooledDataSource(jdbcUrl, jdbcUsername, jdbcPassword);
		try (Connection conn = pooledDataSource.getConnection()) {
		    // 已经获取到第一个Connection
		}
		try (Connection conn = pooledDataSource.getConnection()) {
			// 获取到的是同一个Connection
		}
		try (Connection conn = pooledDataSource.getConnection()) {
			// 获取到的是同一个Connection
		}
	}

	static final String jdbcUrl = "jdbc:mysql://localhost/learnjdbc?useSSL=false&characterEncoding=utf8";
	static final String jdbcUsername = "learn";
	static final String jdbcPassword = "learnpassword";
}
