package com.example.lessom16;

import io.shardingsphere.transaction.annotation.ShardingTransactionType;
import io.shardingsphere.transaction.api.TransactionType;
import io.shardingsphere.transaction.api.TransactionTypeHolder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import javax.sql.XADataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@SpringBootTest
class Lessom16ApplicationTests {

    @Autowired
    private DataSource dataSource;


    //	INSERT INTO `geek_order` (`id`, `shop_id`, `customer_id`, `total_price`, `remark`) VALUES (1, 1, 1, 1, "ds1 order1");
//	INSERT INTO `geek_order` (`id`, `shop_id`, `customer_id`, `total_price`, `remark`) VALUES (2, 3, 2, 1, "ds1 order0");
//	INSERT INTO `geek_order` (`id`, `shop_id`, `customer_id`, `total_price`, `remark`) VALUES (3, 2, 3, 1, "ds0 order1");
//	INSERT INTO `geek_order` (`id`, `shop_id`, `customer_id`, `total_price`, `remark`) VALUES (4, 10, 10, 1, "ds0 order0");
//
    @Test
    @Transactional
    void unXaTransaction() {
        String sql = "insert into geek_order (id,shop_id,customer_id,total_price,remark)values(?,?,?,?,?)";
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, 1);
            preparedStatement.setLong(2, 1);
            preparedStatement.setLong(3, 1);
            preparedStatement.setInt(4, 1);
            preparedStatement.setString(5, "ds1 order1");
            //保存成功
            preparedStatement.executeUpdate();
            connection.commit();

            preparedStatement.setLong(1, 2);
            preparedStatement.setLong(2, 3);
            preparedStatement.setLong(3, 2);
            preparedStatement.setString(4, "aaaaaaaaaaaaa");
            preparedStatement.setString(5, "ds1 order0");
            // 保存失败
            preparedStatement.executeUpdate();
            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    void xaTransaction() {
        TransactionTypeHolder.set(TransactionType.XA); // 支持 TransactionType.LOCAL, TransactionType.XA, TransactionType.BASE
        String sql = "insert into geek_order (id,shop_id,customer_id,total_price,remark)values(?,?,?,?,?)";
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, 1);
            preparedStatement.setLong(2, 1);
            preparedStatement.setLong(3, 1);
            preparedStatement.setInt(4, 1);
            preparedStatement.setString(5, "ds1 order1");
            //保存成功
            preparedStatement.executeUpdate();

            preparedStatement.setLong(1, 2);
            preparedStatement.setLong(2, 3);
            preparedStatement.setLong(3, 2);
            preparedStatement.setString(4, "aaaaaaaaaaaaa");
            preparedStatement.setString(5, "ds1 order0");
            // 保存失败
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
