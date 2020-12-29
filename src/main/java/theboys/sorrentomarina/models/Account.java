package theboys.sorrentomarina.models;

/**
 * @author theboys
 */
public class Account {

  private String email, password;
  private int roleId, id;

  public Account() {
    super();
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getRoleId() {
    return roleId;
  }

  public void setRoleId(int roleId) {
    this.roleId = roleId;
  }

  public boolean isAdmin() {
    return roleId == 1;
  }

  public boolean isOwner() {
    return roleId == 2;
  }

  public boolean isGuest() {
    return roleId == 3;
  }
}
