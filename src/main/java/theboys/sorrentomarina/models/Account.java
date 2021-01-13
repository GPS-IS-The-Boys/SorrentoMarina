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

  /**
   * @return id
   */
  public int getId() {
    return id;
  }

  /**
   * Setta id
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * @return e-mail
   */
  public String getEmail() {
    return email;
  }

  /**
   * Setta e-mail
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * @return password
   */
  public String getPassword() {
    return password;
  }

  /**
   * Setta password
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * @return roleId
   */
  public int getRoleId() {
    return roleId;
  }

  /**
   * Setta roleId
   */
  public void setRoleId(int roleId) {
    this.roleId = roleId;
  }

  /**
   * @return boolean
   */
  public boolean isAdmin() {
    return roleId == 1;
  }

  /**
   * @return boolean
   */
  public boolean isOwner() {
    return roleId == 2;
  }

  /**
   * @return boolean
   */
  public boolean isGuest() {
    return roleId == 3;
  }
}
