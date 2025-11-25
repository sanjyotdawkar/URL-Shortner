package com.shortener;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UrlDao {

    public String saveUrl(String longUrl, String shortCode) {
        String sql = "INSERT INTO urls(long_url, short_code) VALUES (?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, longUrl);
            ps.setString(2, shortCode);
            ps.executeUpdate();

            return shortCode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getLongUrl(String shortCode) {
        String sql = "SELECT long_url FROM urls WHERE short_code = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, shortCode);
            ResultSet rs = ps.executeQuery();

            if (rs.next())
                return rs.getString("long_url");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void incrementClicks(String shortCode) {
        String sql = "UPDATE urls SET clicks = clicks + 1 WHERE short_code = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, shortCode);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<UrlData> getAnalytics() {
        List<UrlData> list = new ArrayList<>();
        String sql = "SELECT * FROM urls";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new UrlData(
                        rs.getInt("id"),
                        rs.getString("long_url"),
                        rs.getString("short_code"),
                        rs.getInt("clicks")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
