package com.gmail.cubitverde.CustomFishingRevamped.menus.lootCollections;

import com.gmail.cubitverde.CustomFishingRevamped.actions.collections.NewCollectionItem;
import com.gmail.cubitverde.CustomFishingRevamped.actions.collections.drop.DeleteDropCommand;
import com.gmail.cubitverde.CustomFishingRevamped.actions.collections.drop.NewDropCommand;
import com.gmail.cubitverde.CustomFishingRevamped.actions.menus.OpenMenu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.PageMenu;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Collection;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Drop;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Icon;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.GuiUtils;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.MiscUtils;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.PluginUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.LinkedList;

public class DropCommands implements PageMenu {
    private Player player;
    private Collection collection;
    private Drop drop;

    public DropCommands(Player player, Collection collection, Drop drop) {
        this.player = player;
        this.collection = collection;
        this.drop = drop;
    }

    @Override
    public Inventory getMenu() {
        return getMenu(1);
    }

    @Override
    public Inventory getMenu(int page) {
        LinkedList<Icon> icons = new LinkedList<>();
        LinkedList<String> commands = drop.getCommands();

        for (String command : commands) {
            Icon icon = new Icon(MiscUtils.CreateItem(Material.COMMAND_BLOCK, ChatColor.GREEN + command,
                    ChatColor.DARK_RED + "Shift click to delete this command"));
            icon.addShiftAction(new DeleteDropCommand(drop, command));
            icon.addShiftAction(new OpenMenu(player, new DropCommands(player, collection, drop)));
            icons.add(icon);
        }

        return GuiUtils.BuildInventory(player, icons, ChatColor.DARK_GREEN + "[Drop Commands]", 6*9,
                new DropSettings(player, collection, drop), page, new NewDropCommand(player, drop, this), false, this);
    }
}
