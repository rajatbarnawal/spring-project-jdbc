package com.example.demo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Client;

@Repository
public class ClientJDBCRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	class ClientRowMapper implements RowMapper< Client >{
		@Override
		public Client mapRow(ResultSet rs,int rowNum) throws SQLException {
			Client client = new Client();
			client.setId(rs.getInt("id"));
			client.setClientName(rs.getString("clientName"));
			client.setAge(rs.getInt("age"));
			return client;
		}
		
	}
	public List < Client > getAllForNow(){
		return jdbcTemplate.query("select * from client", new ClientRowMapper());
	}
	
	public Optional < Client > getById(int id) {
		return Optional.of(jdbcTemplate.queryForObject("select * from client where id=?", new 
				Object[] {id}, new BeanPropertyRowMapper < Client > (Client.class)));
	}
	
	public int deleteById(long id) {
        return jdbcTemplate.update("delete from client where id=?", new Object[] {
            id
        });
    }
	
	public int insert(Client client) {
		return jdbcTemplate.update("insert into client (id, clientName, age) " + "values(?, ?, ?)",
	            new Object[] {
	                client.getId(), client.getClientName(), client.getAge()
	            });
	}
	public int update(Client client) {
        return jdbcTemplate.update("update client " + " set clientName = ?, age = ? " + " where id = ?",
            new Object[] {
                client.getClientName(), client.getAge(), client.getId()
            });
    }
}


