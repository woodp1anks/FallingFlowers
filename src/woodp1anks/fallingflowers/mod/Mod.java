package woodp1anks.fallingflowers.mod;

public class Mod {
    private final String name;
    private boolean enabled;
    private int key;

    public Mod(String name,boolean enabled) {
        this.name = name;
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public int getKey() {
        return key;
    }

    public void onRender() {

    }

    public void onUpdate() {

    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
