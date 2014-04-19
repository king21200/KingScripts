package parabot.strategy;

import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.api.methods.Camera;
import org.rev317.api.methods.SceneObjects;
import org.rev317.api.wrappers.scene.SceneObject;

public class WalkToRangeStrategy implements Strategy {
    @Override
    public boolean activate() {
        SceneObject[] ranges = SceneObjects.getNearest(2728);
        SceneObject range = ranges[0];
        Camera.turnTo(range);
        return (!range.isOnScreen());
    }

    @Override
    public void execute() {
    	SceneObject[] ranges = SceneObjects.getNearest(2728);
    	SceneObject range = ranges[0];
    	if (range != null) {
    		range.getLocation().clickMM();
    	}
    }
}
