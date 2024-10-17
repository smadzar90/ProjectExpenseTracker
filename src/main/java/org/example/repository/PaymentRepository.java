package org.example.repository;

import org.example.model.Category;
import org.example.model.PaymentMethod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentRepository extends EntityRepository<PaymentMethod> {
    private final String FIND_SQL = """
            SELECT ID AS PM_ID, NAME AS PM_NAME, DESCRIPTION AS PM_DESCRIPTION FROM PAYMENT_METHOD WHERE ID=?
            """;
    public PaymentRepository(Connection connection) {
        super(connection);
    }

    @Override
    public PaymentMethod mapResultSetToEntity(ResultSet rs) {
        try {
            PaymentMethod payment = new PaymentMethod(rs.getString("PM_NAME"), rs.getString("PM_DESCRIPTION"));
            payment.setId(rs.getLong("PM_ID"));
            return payment;
        } catch (SQLException e) {
            throw new RuntimeException("Error occurred while mapping the result set to Payment entity. " + e.getMessage());
        }
    }

    @Override
    String getFindSQL() {
        return FIND_SQL;
    }
}
