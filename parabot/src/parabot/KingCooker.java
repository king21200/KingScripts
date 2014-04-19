package parabot;
import java.util.ArrayList;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;

import parabot.strategy.BankStrategy;
import parabot.strategy.CookStrategy;
import parabot.strategy.WalkToRangeStrategy;
import parabot.gui.KingCookerGUI;

 
/**
Made by: king21200
 */
@ScriptManifest(author = "king21200", category = Category.COOKING, description = "Cooks food in Catherby, Start in bank, "
		+ "Make sure door is open so you can access the range before starting", name = "King_Cooker", servers = {"PKHonor"}, version = 1.3)
public class KingCooker extends Script {
private ArrayList<Strategy> strategies;
public static int rawFishId;
public static KingCookerGUI g;
public static boolean guiWait;

        @Override
        public boolean onExecute() {
        	g = new KingCookerGUI();
        	strategies = new ArrayList<Strategy>();       
        	guiWait = true;
        	strategies.add(new BankStrategy());
        	strategies.add(new WalkToRangeStrategy());
        	strategies.add(new CookStrategy());
            provide(strategies);
            g.setVisible(true);
            while (guiWait) {
                Time.sleep(100);
            }         
                return true;
        }
                       
        
        @Override
        public void onFinish() {
 
        }
}