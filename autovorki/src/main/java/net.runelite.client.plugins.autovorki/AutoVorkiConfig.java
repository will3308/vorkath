/*
 * Copyright (c) 2018, Andrew EP | ElPinche256 <https://github.com/ElPinche256>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.autovorki;

import lombok.Getter;
import net.runelite.api.ItemID;
import net.runelite.api.ObjectID;
import net.runelite.client.config.*;

@ConfigGroup("AutoVorkiConfig")
public interface AutoVorkiConfig extends Config {
    @ConfigItem(keyName = "startVorki", name = "Start/Stop", description = "", position = 0, title = "startVorki")
    default Button startVorki() {
        return new Button();
    }

    @ConfigItem(keyName = "showOverlay", name = "Show UI", description = "Show the UI on screen", position = 1)
    default boolean showOverlay() {
        return true;
    }

    @ConfigSection(
            name = "Weapons",
            description = "",
            position = 2,
            keyName = "weaponsSection"
    )
    String weaponsSection = "Weapons";

    @ConfigItem(keyName = "mainhandID", name = "MH", description = "Your main weapon", position = 1, section = weaponsSection)
    default Mainhand mainhand() {
        return Mainhand.DRAGON_HUNTER_LANCE;
    }

    @ConfigItem(keyName = "offhandID", name = "OH", description = "Your offhand item", position = 3, section = weaponsSection)
    default Offhand offhand() {
        return Offhand.AVERNIC_DEFENDER;
    }

    @ConfigItem(keyName = "useSpec", name = "Spec", description = "Special attack weapon<br>Will be ignored if using range", position = 4, section = weaponsSection)
    default Spec useSpec() {
        return Spec.BANDOS_GODSWORD;
    }

    @ConfigItem(keyName = "useStaff", name = "Equip staff", description = "Equip a staff for crumble undead<br>Useful if your magic attack is too low", position = 5, section = weaponsSection)
    default boolean useStaff() {
        return true;
    }

    @ConfigItem(keyName = "staffID", name = "Staff ID", description = "The item ID of your magic weapon", position = 6, hidden = true, unhide = "useStaff", section = weaponsSection)
    default int staffID() {
        return ItemID.SANGUINESTI_STAFF;
    }

    @ConfigItem(keyName = "useDragonBolts", name = "Use Dragon bolt versions", description = "Use dragon variations of bolts during the kill", position = 7, section = weaponsSection)
    default boolean useDragonBolts() {
        return true;
    }

    @ConfigItem(keyName = "useDiamond", name = "Use Diamond (e)", description = "Use diamond bolts and ruby during the kill", position = 7, section = weaponsSection)
    default boolean useDiamond() {
        return true;
    }

    @ConfigSection(
            name = "Consumables",
            description = "",
            position = 3,
            keyName = "consumablesSection"
    )
    String consumablesSection = "Consumables";

    @ConfigItem(keyName = "foodID", name = "Food", description = "The name of your food", position = 1, section = consumablesSection)
    default Food food() {
        return Food.ANGLERFISH;
    }

    @Range(min = 1, max = 28)
    @ConfigItem(keyName = "withdrawFood", name = "Withdraw food", description = "The amount of food to withdraw when banking", position = 2, section = consumablesSection)
    default int withdrawFood() {
        return 14;
    }

    @Range(min = 1, max = 14)
    @ConfigItem(keyName = "minFood", name = "Minimum food", description = "Minimum amount of food per kill", position = 6, section = consumablesSection)
    default int minFood() {
        return 4;
    }

    @Range(min = 1, max = 99)
    @ConfigItem(keyName = "eatAt", name = "Eat at", description = "Eat food when under this HP", position = 7, section = consumablesSection)
    default int eatAt() {
        return 35;
    }

    @ConfigItem(keyName = "overEat", name = "Overeat at bank", description = "Eat to above your max HP at the bank with anglerfish", position = 8, section = consumablesSection)
    default boolean overEat() {
        return false;
    }

    @ConfigItem(keyName = "prayerID", name = "Prayer restore", description = "The name of your prayer restore", position = 10, section = consumablesSection)
    default Prayer prayer() {
        return Prayer.PRAYER_POTION;
    }

    @Range(min = 1, max = 8)
    @ConfigItem(keyName = "prayerAmount", name = "Prayer pots", description = "Quantity of prayer restores to bring", position = 11, section = consumablesSection)
    default int prayerAmount() {
        return 4;
    }

    @Range(min = 1, max = 8)
    @ConfigItem(keyName = "minPray", name = "Minimum pray", description = "Minimum amount of prayer DOSES for new kill", position = 12, section = consumablesSection)
    default int minPray() {
        return 4;
    }

    @Range(min = 1, max = 99)
    @ConfigItem(keyName = "restoreAt", name = "Drink prayer at", description = "Drink prayer restore when under this amount of prayer", position = 13, section = consumablesSection)
    default int restoreAt() {
        return 20;
    }

    @ConfigItem(keyName = "antifireID", name = "Antifire", description = "The name of your antifire potion", position = 14, section = consumablesSection)
    default Antifire antifire() {
        return Antifire.EXT_SUPER_ANTIFIRE;
    }

    @ConfigItem(keyName = "drinkAntifire", name = "Drink antifire", description = "Automatically drink antifire", position = 15, section = consumablesSection)
    default boolean drinkAntifire() {
        return true;
    }

    @ConfigItem(keyName = "antivenomID", name = "Antivenom", description = "The name of your antivenom potion", position = 16, section = consumablesSection)
    default Antivenom antivenom() {
        return Antivenom.ANTI_VENOM_PLUS;
    }

    @ConfigItem(keyName = "superCombatID", name = "Boost", description = "The name of your super combat pot", position = 17, section = consumablesSection)
    default SuperCombat superCombat() {
        return SuperCombat.DIVINE_SUPER_COMBAT;
    }

    @Range(min = 70, max = 120)
    @ConfigItem(keyName = "boostLevel", name = "Re-boost at", description = "The level to drink re-pot at<br>Range: checks range level<br>Melee: checks strength level", position = 18, section = consumablesSection)
    default int boostLevel() {
        return 107;
    }

    @ConfigSection(
            name = "Teleports + PoH",
            description = "",
            position = 4,
            keyName = "teleportsSection"
    )
    String teleportsSection = "Teleports";

    @ConfigItem(keyName = "houseTele", name = "PoH", description = "The name of your house teleport", position = 19, section = teleportsSection)
    default HouseTele houseTele() { return HouseTele.CONSTRUCTION_CAPE_T; }

    @ConfigItem(keyName = "usePool", name = "Use PoH pool", description = "Restore PRAYER and HP with rejuv pool in PoH", position = 20, section = teleportsSection)
    default boolean usePool() {
        return true;
    }

    @ConfigItem(keyName = "poolID", name = "Pool ID", description = "Game Object ID for pool in PoH", position = 21, section = teleportsSection, hidden = true, unhide = "usePool")
    default int poolID() {
        return 29241;
    }

    @ConfigItem(keyName = "cMoonClanTele", name = "Lunar Isle ID", description = "Game Object ID for Lunar Isle teleport", position = 22, section = teleportsSection)
    default int cMoonClanTele() {
        return ObjectID.PORTAL_NEXUS_33402;
    }

    @ConfigItem(keyName = "rellekkaTele", name = "Rellekka", description = "The method of travelling to Rellekka after banking", position = 23, section = teleportsSection)
    default RellekkaTele rellekkaTele() { return RellekkaTele.TALK_TO_BANKER; }

    @ConfigSection(
            name = "Loot",
            description = "",
            position = 5,
            keyName = "lootSection"
    )
    String lootSection = "Loot";

    @ConfigItem(keyName = "lootBones", name = "Loot Superior dragon bones", description = "", position = 992, section = lootSection)
    default boolean lootBones() {
        return true;
    }
    @ConfigItem(keyName = "lootHides", name = "Loot Un-noted Blue dragonhide", description = "", position = 993, section = lootSection)
    default boolean lootHides() {
        return false;
    }

    @ConfigItem(keyName = "eatLoot", name = "Eat food to loot", description = "", position = 994, section = lootSection)
    default boolean eatLoot() {
        return true;
    }

    @ConfigItem(keyName = "lootValue", name = "Item value to loot", description = "Loot items over this value", position = 995, section = lootSection)
    default int lootValue() {
        return 25000;
    }

    @ConfigSection(
            name = "Custom Items",
            description = "",
            position = 6,
            keyName = "specificItems",
            closedByDefault = true
    )
    String specificItems = "Custom Items";

    @ConfigItem(keyName = "includedItems", name = "Included items", description = "Full or partial names of items to loot regardless of value<br>Seperate with a comma", position = 996, section = specificItems)
    default String includedItems() {
        return "rune longsword";
    }

    @ConfigItem(keyName = "excludedItems", name = "Excluded items", description = "Full or partial names of items to NOT loot<br>Seperate with a comma", position = 997, section = specificItems)
    default String excludedItems() {
        return "ruby bolt,diamond bolt,emerald bolt,dragonstone bolt";
    }

    @ConfigSection(
            name = "Sleep Delays",
            description = "",
            position = 7,
            keyName = "sleepDelays",
            closedByDefault = true
    )
    String sleepDelays = "Sleep Delays";

    @Range(
            min = 0,
            max = 550
    )
    @ConfigItem(
            keyName = "sleepMin",
            name = "Sleep Min",
            description = "",
            position = 2,
            section = sleepDelays
    )
    default int sleepMin() {
        return 20;
    }

    @Range(
            min = 0,
            max = 550
    )
    @ConfigItem(
            keyName = "sleepMax",
            name = "Sleep Max",
            description = "",
            position = 3,
            section = sleepDelays
    )
    default int sleepMax() {
        return 200;
    }

    @Range(
            min = 0,
            max = 550
    )
    @ConfigItem(
            keyName = "sleepTarget",
            name = "Sleep Target",
            description = "",
            position = 4,
            section = sleepDelays
    )
    default int sleepTarget() {
        return 50;
    }

    @Range(
            min = 0,
            max = 550
    )
    @ConfigItem(
            keyName = "sleepDeviation",
            name = "Sleep Deviation",
            description = "",
            position = 5,
            section = sleepDelays
    )
    default int sleepDeviation() {
        return 10;
    }

    @ConfigItem(
            keyName = "sleepWeightedDistribution",
            name = "Sleep Weighted Distribution",
            description = "Shifts the random distribution towards the lower end at the target, otherwise it will be an even distribution",
            position = 6,
            section = sleepDelays
    )
    default boolean sleepWeightedDistribution() {
        return false;
    }

    @ConfigSection(
            name = "Tick Delays",
            description = "",
            position = 8,
            keyName = "tickDelays",
            closedByDefault = true
    )
    String tickDelays = "Tick Delays";

    @Range(
            min = 0,
            max = 10
    )
    @ConfigItem(
            keyName = "tickDelaysMin",
            name = "Game Tick Min",
            description = "",
            position = 8,
            section = tickDelays
    )
    default int tickDelaysMin() {
        return 1;
    }

    @Range(
            min = 0,
            max = 10
    )
    @ConfigItem(
            keyName = "tickDelaysMax",
            name = "Game Tick Max",
            description = "",
            position = 9,
            section = tickDelays
    )
    default int tickDelaysMax() {
        return 3;
    }

    @Range(
            min = 0,
            max = 10
    )
    @ConfigItem(
            keyName = "tickDelaysTarget",
            name = "Game Tick Target",
            description = "",
            position = 10,
            section = tickDelays
    )
    default int tickDelaysTarget() {
        return 2;
    }

    @Range(
            min = 0,
            max = 10
    )
    @ConfigItem(
            keyName = "tickDelaysDeviation",
            name = "Game Tick Deviation",
            description = "",
            position = 11,
            section = tickDelays
    )
    default int tickDelaysDeviation() {
        return 1;
    }

    @ConfigItem(
            keyName = "tickDelaysWeightedDistribution",
            name = "Game Tick Weighted Distribution",
            description = "Shifts the random distribution towards the lower end at the target, otherwise it will be an even distribution",
            position = 12,
            section = tickDelays
    )
    default boolean tickDelaysWeightedDistribution() {
        return false;
    }

    @ConfigItem(keyName = "invokes", name = "Use invokes (use with caution)", description = "Use at your own risk", position = 998)
    default boolean invokes() {
        return false;
    }

    @ConfigItem(keyName = "invokeWalk", name = "Invoke walking (use with caution)", description = "Use at your own risk", position = 999)
    default boolean invokeWalk() {
        return false;
    }

    @ConfigItem(keyName = "debug", name = "Debug Messages", description = "", position = 1000)
    default boolean debug() {
        return false;
    }

    enum Mainhand {
        DRAGON_HUNTER_LANCE(ItemID.DRAGON_HUNTER_LANCE, 1),
        GHRAZI_RAPIER(ItemID.GHRAZI_RAPIER, 1),
        ZAMORAKIAN_HASTA(ItemID.ZAMORAKIAN_HASTA, 1),
        ABYSSAL_DAGGER(ItemID.ABYSSAL_DAGGER, 1),
        LEAF_BLADED_SWORD(ItemID.LEAFBLADED_SWORD, 1),
        DRAGON_HUNTER_CROSSBOW(ItemID.DRAGON_HUNTER_CROSSBOW, 7),
        DRAGON_CROSSBOW(ItemID.DRAGON_CROSSBOW, 7),
        RUNE_CROSSBOW(ItemID.RUNE_CROSSBOW, 7),
        BLOWPIPE(ItemID.TOXIC_BLOWPIPE, 5);

        @Getter private final int itemId, range;
        Mainhand (int itemId, int range) {
            this.itemId = itemId;
            this.range = range;
        }
    }

    enum Offhand {
        AVERNIC_DEFENDER(ItemID.AVERNIC_DEFENDER),
        AVERNIC_DEFENDER_L(ItemID.AVERNIC_DEFENDER_L),
        DRAGON_DEFENDER(ItemID.DRAGON_DEFENDER),
        DRAGONFIRE_SHIELD(ItemID.DRAGONFIRE_SHIELD),
        TOKTZ_KET_XIL(ItemID.TOKTZKETXIL),
        RUNE_DEFENDER(ItemID.RUNE_DEFENDER),
        DRAGONFIRE_WARD(ItemID.DRAGONFIRE_WARD),
        ANTI_DRAGON_SHIELD(ItemID.ANTIDRAGON_SHIELD),
        TWISTED_BUCKLER(ItemID.TWISTED_BUCKLER),
        NONE(-1);

        @Getter private final int itemId;
        Offhand(int itemId) {
            this.itemId = itemId;
        }
    }

    enum RellekkaTele {
        TALK_TO_BANKER(0),
        FREMENNIK_BOOTS_4(1),
        RETURN_ORB(29712);

        @Getter private final int option;
        RellekkaTele(int option) { this.option = option; }
    }

    enum Spec {
        NONE(-1, 0),
        BANDOS_GODSWORD(ItemID.BANDOS_GODSWORD, 50),
        DRAGON_WARHAMMER(ItemID.DRAGON_WARHAMMER, 50),
        DRAGON_CLAWS(ItemID.DRAGON_CLAWS, 50),
        BLOWPIPE(ItemID.TOXIC_BLOWPIPE, 50);

        @Getter private final int itemId, specAmt;
        Spec(int itemId, int specAmt) {
            this.itemId = itemId;
            this.specAmt = specAmt;
        }
    }

    enum Food {
        MANTA_RAY(ItemID.MANTA_RAY),
        TUNA_POTATO(ItemID.TUNA_POTATO),
        DARK_CRAB(ItemID.DARK_CRAB),
        ANGLERFISH(ItemID.ANGLERFISH),
        SEA_TURTLE(ItemID.SEA_TURTLE),
        MUSHROOM_POTATO(ItemID.MUSHROOM_POTATO),
        SHARK(ItemID.SHARK),
        COOKED_KARAMBWAN(ItemID.COOKED_KARAMBWAN);
        @Getter
        private final int id;

        Food(int id) {
            this.id = id;
        }
    }

    enum Prayer {
        PRAYER_POTION(ItemID.PRAYER_POTION4, ItemID.PRAYER_POTION3, ItemID.PRAYER_POTION2, ItemID.PRAYER_POTION1),
        SUPER_RESTORE(ItemID.SUPER_RESTORE4, ItemID.SUPER_RESTORE3, ItemID.SUPER_RESTORE2, ItemID.SUPER_RESTORE1);

        @Getter
        private final int dose4, dose3, dose2, dose1;

        Prayer(int dose4, int dose3, int dose2, int dose1) {
            this.dose1 = dose1;
            this.dose2 = dose2;
            this.dose3 = dose3;
            this.dose4 = dose4;
        }
    }

    enum Antifire {
        ANTIFIRE_POTION(ItemID.ANTIFIRE_POTION4, ItemID.ANTIFIRE_POTION3, ItemID.ANTIFIRE_POTION2, ItemID.ANTIFIRE_POTION1),
        EXT_ANTIFIRE_POTION(ItemID.EXTENDED_ANTIFIRE4, ItemID.EXTENDED_ANTIFIRE3, ItemID.EXTENDED_ANTIFIRE2, ItemID.EXTENDED_ANTIFIRE1),
        SUPER_ANTIFIRE(ItemID.SUPER_ANTIFIRE_POTION4, ItemID.SUPER_ANTIFIRE_POTION3, ItemID.SUPER_ANTIFIRE_POTION2, ItemID.SUPER_ANTIFIRE_POTION1),
        EXT_SUPER_ANTIFIRE(ItemID.EXTENDED_SUPER_ANTIFIRE4, ItemID.EXTENDED_SUPER_ANTIFIRE3, ItemID.EXTENDED_SUPER_ANTIFIRE2, ItemID.EXTENDED_SUPER_ANTIFIRE1);

        @Getter
        private final int dose4, dose3, dose2, dose1;

        Antifire(int dose4, int dose3, int dose2, int dose1) {
            this.dose1 = dose1;
            this.dose2 = dose2;
            this.dose3 = dose3;
            this.dose4 = dose4;
        }
    }

    enum Antivenom {
        ANTI_VENOM(ItemID.ANTIVENOM4, ItemID.ANTIVENOM3, ItemID.ANTIVENOM2, ItemID.ANTIVENOM1),
        ANTI_VENOM_PLUS(ItemID.ANTIVENOM4_12913, ItemID.ANTIVENOM3_12915, ItemID.ANTIVENOM2_12917, ItemID.ANTIVENOM1_12919),
        SERPENTINE_HELM(ItemID.SERPENTINE_HELM, -1, -1, -1);

        @Getter
        private final int dose4, dose3, dose2, dose1;

        Antivenom(int dose4, int dose3, int dose2, int dose1) {
            this.dose1 = dose1;
            this.dose2 = dose2;
            this.dose3 = dose3;
            this.dose4 = dose4;
        }
    }

    enum HouseTele {
        CONSTRUCTION_CAPE_T(ItemID.CONSTRUCT_CAPET),
        CONSTRUCTION_CAPE(ItemID.CONSTRUCT_CAPE),
        HOUSE_TABLET(ItemID.TELEPORT_TO_HOUSE),
        HOUSE_TELEPORT(1);

        @Getter
        private final int id;

        HouseTele(int id) {
            this.id = id;
        }
    }

    enum SuperCombat {
        DIVINE_SUPER_COMBAT(ItemID.DIVINE_SUPER_COMBAT_POTION4, ItemID.DIVINE_SUPER_COMBAT_POTION3, ItemID.DIVINE_SUPER_COMBAT_POTION2, ItemID.DIVINE_SUPER_COMBAT_POTION1),
        SUPER_COMBAT(ItemID.SUPER_COMBAT_POTION4, ItemID.SUPER_COMBAT_POTION3, ItemID.SUPER_COMBAT_POTION2, ItemID.SUPER_COMBAT_POTION1),
        DIVINE_BASTION(ItemID.DIVINE_BASTION_POTION4, ItemID.DIVINE_BASTION_POTION3, ItemID.DIVINE_BASTION_POTION2, ItemID.DIVINE_BASTION_POTION1),
        BASTION(ItemID.BASTION_POTION4, ItemID.BASTION_POTION3, ItemID.BASTION_POTION2, ItemID.BASTION_POTION1),
        DIVINE_RANGING(ItemID.DIVINE_RANGING_POTION4, ItemID.DIVINE_RANGING_POTION3, ItemID.DIVINE_RANGING_POTION2, ItemID.DIVINE_RANGING_POTION1),
        RANGING(ItemID.RANGING_POTION4, ItemID.RANGING_POTION3, ItemID.RANGING_POTION2, ItemID.RANGING_POTION1);

        @Getter
        private final int dose4, dose3, dose2, dose1;

        SuperCombat(int dose4, int dose3, int dose2, int dose1) {
            this.dose4 = dose4;
            this.dose3 = dose3;
            this.dose2 = dose2;
            this.dose1 = dose1;
        }
    }

    enum MoonClanTele {
        PORTAL_NEXUS(-1),
        MOONCLAN_PORTAL(-1);

        @Getter
        private final int objectID;

        MoonClanTele(int objectID) {
            this.objectID = objectID;
        }
    }
}