package com.zimcarry.faq;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zimcarry.db.DBConn;

public class FaqDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public List<FaqDTO> selectFaqList() {
		List<FaqDTO> faqList = new ArrayList<FaqDTO>();
		try {
			String sql = "SELECT f_idx, f_question, f_answer, f_writedate, f_hidden FROM tb_faq";
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				FaqDTO faqDTO = new FaqDTO();
				faqDTO.setfIdx(rs.getInt("f_idx"));
				faqDTO.setfQuestion(rs.getString("f_question"));
				faqDTO.setfAnswer(rs.getString("f_answer"));
				faqDTO.setfWritedate(rs.getDate("f_writedate"));
				faqDTO.setfHidden(rs.getString("f_hidden"));
				faqList.add(faqDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			DBConn.close(conn, pstmt, rs);
		}
		return faqList;
	}
}
