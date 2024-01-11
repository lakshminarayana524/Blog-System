package com.blog.entity;

import java.sql.Blob;
import java.sql.SQLException;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_data")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "name")
    String name;
    @Column(name = "username", unique = true)
    String username;
    @Column(name = "contact", unique = true)
    String contactno;
    @Column(name = "email", unique = true)
    String email;
    @Column(name = "password")
    String pass;
    @Lob
    @Column(name = "image", columnDefinition = "LONGBLOB")
    private Blob image;

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    // Additional setter to handle default image path
    public void setImage(String imagePath) {
        // Convert imagePath to Blob and set it as the image
        // This assumes you have a utility method to convert a file path to Blob
        // You might need to adjust this part based on your actual implementation
        try {
            // If the provided image path is null or empty, set a default path
            if (imagePath == null || imagePath.isEmpty()) {
                imagePath = "./imgs/profile.png";
            }

            // Convert imagePath to Blob and set it as the image
            // This is a simplified example, you might need to adjust this based on your actual implementation
            // e.g., using FileInputStream, etc.
            // Replace the following line with your actual Blob conversion logic
            this.image = convertImagePathToBlob(imagePath);
        } catch (SQLException e) {
            // Handle SQLException
            e.printStackTrace();
        }
    }

    private Blob convertImagePathToBlob(String imagePath) throws SQLException {
        // Your logic to convert imagePath to Blob
        // This is a placeholder, you should implement the actual conversion
        // For example, you might use FileInputStream to read the image file and convert it to Blob
        // Replace the following line with your actual implementation
        // Blob blob = new SerialBlob(imageBytes);
        return null;
    }

    // Other getters and setters...

    public String toString() {
        return "User[id= " + id + ", name= " + name + ", username=" + username + ", contact=" + contactno + ", email="
                + email + ", pass=" + pass + "]";
    }

	public void setContactno(String contact) {
		// TODO Auto-generated method stub
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getContactno() {
		return contactno;
	}

	
}
