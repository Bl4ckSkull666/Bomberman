package io.github.mdsimmo.bomberman.commands.game.set;

import java.util.List;

import org.bukkit.command.CommandSender;

import io.github.mdsimmo.bomberman.Bomberman;
import io.github.mdsimmo.bomberman.Game;
import io.github.mdsimmo.bomberman.commands.Command;
import io.github.mdsimmo.bomberman.commands.GameCommand;

public class Lives extends GameCommand {

	public Lives(Command parent) {
		super(parent);
	}

	@Override
	public String name() {
		return "lives";
	}

	@Override
	public List<String> shortOptions(CommandSender sender, List<String> args) {
		return null;
	}

	@Override
	public boolean runShort(CommandSender sender, List<String> args, Game game) {
		if (args.size() != 1)
			return false;
		int amount;
		try {
			amount = Integer.parseInt(args.get(0));
		} catch (Exception e) {
			return false;
		}
		game.setLives(amount);
		Bomberman.sendMessage(sender, "Lives set");
		return true;
	}

	@Override
	public String description() {
		return "Sets players' initial lives";
	}

	@Override
	public String usage(CommandSender sender) {
		return "/" + path() + "<game> <amount>";
	}

	@Override
	public Permission permission() {
		return Permission.GAME_DICTATE;
	}

}
