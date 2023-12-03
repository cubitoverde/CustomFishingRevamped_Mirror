package com.gmail.cubitverde.CustomFishingRevamped.menus.fishingLoot.conditionalLoot.conditions.players;

import com.gmail.cubitverde.CustomFishingRevamped.actions.conditions.players.ModifyMaxPlayers;
import com.gmail.cubitverde.CustomFishingRevamped.actions.conditions.players.ModifyMinPlayers;
import com.gmail.cubitverde.CustomFishingRevamped.actions.menus.OpenMenu;
import com.gmail.cubitverde.CustomFishingRevamped.conditions.Condition;
import com.gmail.cubitverde.CustomFishingRevamped.conditions.PlayersCondition;
import com.gmail.cubitverde.CustomFishingRevamped.menus.Menu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.fishingLoot.conditionalLoot.collections.BucketCollections;
import com.gmail.cubitverde.CustomFishingRevamped.menus.fishingLoot.conditionalLoot.conditions.BucketConditions;
import com.gmail.cubitverde.CustomFishingRevamped.objects.*;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.ConditionUtils;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.GuiUtils;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.MiscUtils;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.PluginUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.Map;

public class PlayersConditionSettings implements Menu {
    private Player player;
    private ConditionalBucket bucket;
    private LootCondition lootCondition;

    public PlayersConditionSettings(Player player, ConditionalBucket bucket, LootCondition lootCondition) {
        this.player = player;
        this.bucket = bucket;
        this.lootCondition = lootCondition;
    }

    @Override
    public Inventory getMenu() {
        Map<Integer, Icon> icons = new HashMap<>();
        PlayersCondition condition = (PlayersCondition) lootCondition.getCondition();

        {
            Icon icon = new Icon(ConditionUtils.AddLootConditionInfoToItem(ConditionUtils.GetConditionInfoItem(condition, true, false), lootCondition, false));
            icons.put(10, icon);
        } {
            Icon icon = ConditionUtils.GetConditionSettingsEnableIcon(lootCondition);
            icon.addAction(new OpenMenu(player, this));
            icons.put(19, icon);
        } {
            Icon icon = ConditionUtils.GetConditionSettingsWhitelistIcon(lootCondition);
            icon.addAction(new OpenMenu(player, this));
            icons.put(20, icon);
        } {
            Icon icon = new Icon(MiscUtils.CreateItem(Material.PAPER, ChatColor.GREEN + "Online players",
                    condition.getSummary()));
            icons.put(11, icon);
        } {
            Icon icon = new Icon(MiscUtils.CreateItem(Material.BLUE_WOOL, ChatColor.GREEN + "Minimum players",
                    ChatColor.DARK_GREEN + "Current minimum: " + ChatColor.WHITE + condition.getMinPlayers(),
                    ChatColor.DARK_GREEN + "Left click: " + ChatColor.GRAY + "Increase by 1",
                    ChatColor.DARK_GREEN + "Right click: " + ChatColor.GRAY + "Reduce by 1"));
            icon.addLAction(new ModifyMinPlayers(condition, 1));
            icon.addRAction(new ModifyMinPlayers(condition, -1));
            icon.addAction(new OpenMenu(player, this));
            icons.put(13, icon);
        } {
            Icon icon = new Icon(MiscUtils.CreateItem(Material.RED_WOOL, ChatColor.GREEN + "Maximum players",
                    ChatColor.DARK_GREEN + "Current maximum: " + ChatColor.WHITE + condition.getMaxPlayers(),
                    ChatColor.DARK_GREEN + "Left click: " + ChatColor.GRAY + "Increase by 1",
                    ChatColor.DARK_GREEN + "Right click: " + ChatColor.GRAY + "Reduce by 1"));
            icon.addLAction(new ModifyMaxPlayers(condition, 1));
            icon.addRAction(new ModifyMaxPlayers(condition, -1));
            icon.addAction(new OpenMenu(player, this));
            icons.put(14, icon);
        }

        return GuiUtils.BuildInventory(player, icons, ChatColor.DARK_GREEN + "[Condition Settings]", 4*9, new BucketConditions(player, bucket));
    }
}
