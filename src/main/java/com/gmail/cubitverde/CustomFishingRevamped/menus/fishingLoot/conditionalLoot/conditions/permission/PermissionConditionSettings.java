package com.gmail.cubitverde.CustomFishingRevamped.menus.fishingLoot.conditionalLoot.conditions.permission;

import com.gmail.cubitverde.CustomFishingRevamped.actions.conditions.permission.ChangePermission;
import com.gmail.cubitverde.CustomFishingRevamped.actions.conditions.players.ModifyMaxPlayers;
import com.gmail.cubitverde.CustomFishingRevamped.actions.conditions.players.ModifyMinPlayers;
import com.gmail.cubitverde.CustomFishingRevamped.actions.menus.OpenMenu;
import com.gmail.cubitverde.CustomFishingRevamped.conditions.PermissionCondition;
import com.gmail.cubitverde.CustomFishingRevamped.conditions.PlayersCondition;
import com.gmail.cubitverde.CustomFishingRevamped.menus.Menu;
import com.gmail.cubitverde.CustomFishingRevamped.menus.fishingLoot.conditionalLoot.conditions.BucketConditions;
import com.gmail.cubitverde.CustomFishingRevamped.objects.ConditionalBucket;
import com.gmail.cubitverde.CustomFishingRevamped.objects.Icon;
import com.gmail.cubitverde.CustomFishingRevamped.objects.LootCondition;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.ConditionUtils;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.GuiUtils;
import com.gmail.cubitverde.CustomFishingRevamped.utilities.MiscUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.Map;

public class PermissionConditionSettings implements Menu {
    private Player player;
    private ConditionalBucket bucket;
    private LootCondition lootCondition;

    public PermissionConditionSettings(Player player, ConditionalBucket bucket, LootCondition lootCondition) {
        this.player = player;
        this.bucket = bucket;
        this.lootCondition = lootCondition;
    }

    @Override
    public Inventory getMenu() {
        Map<Integer, Icon> icons = new HashMap<>();
        PermissionCondition condition = (PermissionCondition) lootCondition.getCondition();

        ConditionUtils.AddBaseConditionSettingsIcons(icons, player, lootCondition, bucket,
                19, 20, 21, this);

        {
            Icon icon = new Icon(MiscUtils.CreateItem(Material.WRITABLE_BOOK, ChatColor.GREEN + "Permission",
                    ChatColor.DARK_GREEN + "Current permission: " + ChatColor.WHITE + condition.getPermission(),
                    ChatColor.DARK_GREEN + "Click: " + ChatColor.GRAY + "Change permission"));
            icon.addAction(new ChangePermission(player, bucket, condition, this));
            icons.put(14, icon);
        }

        return GuiUtils.BuildInventory(player, icons, ChatColor.DARK_GREEN + "[Condition Settings]", 4*9, new BucketConditions(player, bucket));
    }
}
