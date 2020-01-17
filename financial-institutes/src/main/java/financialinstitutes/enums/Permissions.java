package financialinstitutes.enums;

public enum Permissions {
    CREATE_CREDIT("Permission for creation of credits", true),
    AUTHORIZE_CREDIT("Permission for authorize credits", true),
    DELETE_CREDIT("Permission for delete credits", true),
    MODIFY_CREDIT("Permission for modifying credits", true);

    private String permission;
    private boolean hasPermissions;

    private Permissions(String permission, boolean hasPermissions) {
        this.permission = permission;
        this.hasPermissions = hasPermissions;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public boolean isHasPermissions() {
        return hasPermissions;
    }

    public void setHasPermissions(boolean hasPermissions) {
        this.hasPermissions = hasPermissions;
    }
}
