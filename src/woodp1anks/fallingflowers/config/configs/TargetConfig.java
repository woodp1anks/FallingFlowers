package woodp1anks.fallingflowers.config.configs;

import woodp1anks.fallingflowers.config.Config;
import woodp1anks.fallingflowers.utils.TargetUtil;

public class TargetConfig extends Config {
    public TargetConfig() {
        super("Target");
    }

    @Override
    public void syncStart() {
        TargetUtil.setAnimalCanBeTarget(Boolean.parseBoolean(get("animal")));
        TargetUtil.setModCanBeTarget(Boolean.parseBoolean(get("mob")));
        TargetUtil.setPlayerCanBeTarget(Boolean.parseBoolean(get("player")));
    }

    @Override
    public void syncStop() {
        set("animal", String.valueOf(TargetUtil.isAnimalCanBeTarget()));
        set("mob", String.valueOf(TargetUtil.isModCanBeTarget()));
        set("player", String.valueOf(TargetUtil.isPlayerCanBeTarget()));
    }

    @Override
    public void syncDefault() {
        TargetUtil.setPlayerCanBeTarget(true);
        TargetUtil.setAnimalCanBeTarget(false);
        TargetUtil.setModCanBeTarget(false);
    }
}
