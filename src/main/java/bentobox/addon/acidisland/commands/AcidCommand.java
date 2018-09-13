package bentobox.addon.acidisland.commands;

import java.util.List;

import bentobox.addon.acidisland.AcidIsland;
import world.bentobox.bentobox.api.addons.Addon;
import world.bentobox.bentobox.api.commands.CompositeCommand;
import world.bentobox.bentobox.api.commands.admin.AdminClearResetsAllCommand;
import world.bentobox.bentobox.api.commands.admin.AdminClearResetsCommand;
import world.bentobox.bentobox.api.commands.admin.AdminDeleteCommand;
import world.bentobox.bentobox.api.commands.admin.AdminGetRankCommand;
import world.bentobox.bentobox.api.commands.admin.AdminInfoCommand;
import world.bentobox.bentobox.api.commands.admin.AdminRegisterCommand;
import world.bentobox.bentobox.api.commands.admin.AdminSchemCommand;
import world.bentobox.bentobox.api.commands.admin.AdminSetRankCommand;
import world.bentobox.bentobox.api.commands.admin.AdminTeleportCommand;
import world.bentobox.bentobox.api.commands.admin.AdminUnregisterCommand;
import world.bentobox.bentobox.api.commands.admin.AdminVersionCommand;
import world.bentobox.bentobox.api.commands.admin.range.AdminRangeCommand;
import world.bentobox.bentobox.api.commands.admin.team.AdminTeamAddCommand;
import world.bentobox.bentobox.api.commands.admin.team.AdminTeamDisbandCommand;
import world.bentobox.bentobox.api.commands.admin.team.AdminTeamKickCommand;
import world.bentobox.bentobox.api.commands.admin.team.AdminTeamMakeLeaderCommand;
import world.bentobox.bentobox.api.user.User;

public class AcidCommand extends CompositeCommand {

    public AcidCommand(Addon addon, String command) {
        super(addon, command);
    }

    @Override
    public void setup() {
        setPermissionPrefix("acidisland");
        setPermission("acidisland.admin.*");
        setOnlyPlayer(false);
        setParametersHelp("commands.admin.help.parameters");
        setDescription("commands.admin.help.description");
        setWorld(((AcidIsland)getAddon()).getIslandWorld());
        new AdminVersionCommand(this);
        new AdminTeleportCommand(this, "tp");
        new AdminTeleportCommand(this, "tpnether");
        new AdminTeleportCommand(this, "tpend");
        new AdminGetRankCommand(this);
        new AdminSetRankCommand(this);
        new AdminInfoCommand(this);
        // Team commands
        new AdminTeamAddCommand(this);
        new AdminTeamKickCommand(this);
        new AdminTeamDisbandCommand(this);
        new AdminTeamMakeLeaderCommand(this);
        // Schems
        new AdminSchemCommand(this);
        // Register/unregister islands
        new AdminRegisterCommand(this);
        new AdminUnregisterCommand(this);
        // Range
        new AdminRangeCommand(this);
        // Resets
        new AdminClearResetsCommand(this);
        new AdminClearResetsAllCommand(this);
        // Delete
        new AdminDeleteCommand(this);
    }

    @Override
    public boolean execute(User user, String label, List<String> args) {
        if (!args.isEmpty()) {
            user.sendMessage("general.errors.unknown-command", "[label]", "acid");
            return false;
        }
        // By default run the attached help command, if it exists (it should)
        return showHelp(this, user);
    }


}
