/*
 * package com.example.health.UserModel;
 * 
 * import java.util.List;
 * 
 * import javax.persistence.CascadeType; import javax.persistence.Column; import
 * javax.persistence.Entity; import javax.persistence.FetchType; import
 * javax.persistence.GeneratedValue; import javax.persistence.GenerationType;
 * import javax.persistence.Id; import javax.persistence.ManyToMany; import
 * javax.persistence.Table;
 * 
 * 
 * 
 * @Entity
 * 
 * @Table(name="roles") public class Role {
 * 
 * @Id
 * 
 * @Column(name="role_id")
 * 
 * @GeneratedValue (strategy = GenerationType.AUTO) private int id; private
 * String name;
 * 
 * 
 * @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST,
 * CascadeType.MERGE }, mappedBy = "roles") private List<User> users;
 * 
 * 
 * 
 * public int getId() { return id; } public void setId(int id) { this.id = id; }
 * public String getName() { return name; } public void setName(String name) {
 * this.name = name; }
 * 
 * 
 * 
 * }
 */