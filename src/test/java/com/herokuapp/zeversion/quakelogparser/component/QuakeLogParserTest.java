package com.herokuapp.zeversion.quakelogparser.component;

import com.herokuapp.zeversion.quakelogparser.model.Game;
import com.herokuapp.zeversion.quakelogparser.model.Log;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class QuakeLogParserTest {

    @Test
    public void parser() {
        String logs = this.logs();
        Log logParsered = new QuakeLogParser().parser(logs);

        int twoGamesExpected = 2;
        assertThat(logParsered.getGames().size(), equalTo(twoGamesExpected));

        Game firstGame = logParsered.getGames().get(0);
        int zeroExpected = 0;
        assertThat(firstGame.getTotal_kills(), equalTo(zeroExpected));
        assertThat(firstGame.getKills().size(), equalTo(zeroExpected));
        assertThat(firstGame.getKills_by_means().size(), equalTo(zeroExpected));

        Game secondGame = logParsered.getGames().get(1);
        int fifteenKillsExpected = 15;
        assertThat(secondGame.getTotal_kills(), equalTo(fifteenKillsExpected));
        int threePlayersExpected = 3;
        assertThat(secondGame.getKills().size(), equalTo(threePlayersExpected));
        int fourKillsByMeansExpected = 4;
        assertThat(secondGame.getKills_by_means().size(), equalTo(fourKillsByMeansExpected));
    }

    private String logs() {
        return "  0:00 ------------------------------------------------------------\n" +
                "  0:00 InitGame: \\sv_floodProtect\\1\\sv_maxPing\\0\\sv_minPing\\0\\sv_maxRate\\10000\\sv_minRate\\0\\sv_hostname\\Code Miner Server\\g_gametype\\0\\sv_privateClients\\2\\sv_maxclients\\16\\sv_allowDownload\\0\\dmflags\\0\\fraglimit\\20\\timelimit\\15\\g_maxGameClients\\0\\capturelimit\\8\\version\\ioq3 1.36 linux-x86_64 Apr 12 2009\\protocol\\68\\mapname\\q3dm17\\gamename\\baseq3\\g_needpass\\0\n" +
                " 15:00 Exit: Timelimit hit.\n" +
                " 20:34 ClientConnect: 2\n" +
                " 20:34 ClientUserinfoChanged: 2 n\\Isgalamido\\t\\0\\model\\xian/default\\hmodel\\xian/default\\g_redteam\\\\g_blueteam\\\\c1\\4\\c2\\5\\hc\\100\\w\\0\\l\\0\\tt\\0\\tl\\0\n" +
                " 20:37 ClientUserinfoChanged: 2 n\\Isgalamido\\t\\0\\model\\uriel/zael\\hmodel\\uriel/zael\\g_redteam\\\\g_blueteam\\\\c1\\5\\c2\\5\\hc\\100\\w\\0\\l\\0\\tt\\0\\tl\\0\n" +
                " 20:37 ClientBegin: 2\n" +
                " 20:37 ShutdownGame:\n" +
                " 20:37 ------------------------------------------------------------\n" +
                " 20:37 ------------------------------------------------------------\n" +
                " 20:37 InitGame: \\sv_floodProtect\\1\\sv_maxPing\\0\\sv_minPing\\0\\sv_maxRate\\10000\\sv_minRate\\0\\sv_hostname\\Code Miner Server\\g_gametype\\0\\sv_privateClients\\2\\sv_maxclients\\16\\sv_allowDownload\\0\\bot_minplayers\\0\\dmflags\\0\\fraglimit\\20\\timelimit\\15\\g_maxGameClients\\0\\capturelimit\\8\\version\\ioq3 1.36 linux-x86_64 Apr 12 2009\\protocol\\68\\mapname\\q3dm17\\gamename\\baseq3\\g_needpass\\0\n" +
                " 20:38 ClientConnect: 2\n" +
                " 20:38 ClientUserinfoChanged: 2 n\\Isgalamido\\t\\0\\model\\uriel/zael\\hmodel\\uriel/zael\\g_redteam\\\\g_blueteam\\\\c1\\5\\c2\\5\\hc\\100\\w\\0\\l\\0\\tt\\0\\tl\\0\n" +
                " 20:38 ClientBegin: 2\n" +
                " 20:40 Item: 2 weapon_rocketlauncher\n" +
                " 20:40 Item: 2 ammo_rockets\n" +
                " 20:42 Item: 2 item_armor_body\n" +
                " 20:54 Kill: 1022 2 22: <world> killed Isgalamido by MOD_TRIGGER_HURT\n" +
                " 20:59 Item: 2 weapon_rocketlauncher\n" +
                " 21:04 Item: 2 ammo_shells\n" +
                " 21:07 Kill: 1022 2 22: <world> killed Isgalamido by MOD_TRIGGER_HURT\n" +
                " 21:10 ClientDisconnect: 2\n" +
                " 21:15 ClientConnect: 2\n" +
                " 21:15 ClientUserinfoChanged: 2 n\\Isgalamido\\t\\0\\model\\uriel/zael\\hmodel\\uriel/zael\\g_redteam\\\\g_blueteam\\\\c1\\5\\c2\\5\\hc\\100\\w\\0\\l\\0\\tt\\0\\tl\\0\n" +
                " 21:17 ClientUserinfoChanged: 2 n\\Isgalamido\\t\\0\\model\\uriel/zael\\hmodel\\uriel/zael\\g_redteam\\\\g_blueteam\\\\c1\\5\\c2\\5\\hc\\100\\w\\0\\l\\0\\tt\\0\\tl\\0\n" +
                " 21:17 ClientBegin: 2\n" +
                " 21:18 Item: 2 weapon_rocketlauncher\n" +
                " 21:21 Item: 2 item_armor_body\n" +
                " 21:32 Item: 2 item_health_large\n" +
                " 21:33 Item: 2 weapon_rocketlauncher\n" +
                " 21:34 Item: 2 ammo_rockets\n" +
                " 21:42 Kill: 1022 2 22: <world> killed Isgalamido by MOD_TRIGGER_HURT\n" +
                " 21:49 Item: 2 weapon_rocketlauncher\n" +
                " 21:51 ClientConnect: 3\n" +
                " 21:51 ClientUserinfoChanged: 3 n\\Dono da Bola\\t\\0\\model\\sarge/krusade\\hmodel\\sarge/krusade\\g_redteam\\\\g_blueteam\\\\c1\\5\\c2\\5\\hc\\95\\w\\0\\l\\0\\tt\\0\\tl\\0\n" +
                " 21:53 ClientUserinfoChanged: 3 n\\Mocinha\\t\\0\\model\\sarge\\hmodel\\sarge\\g_redteam\\\\g_blueteam\\\\c1\\4\\c2\\5\\hc\\95\\w\\0\\l\\0\\tt\\0\\tl\\0\n" +
                " 21:53 ClientBegin: 3\n" +
                " 22:04 Item: 2 weapon_rocketlauncher\n" +
                " 22:04 Item: 2 ammo_rockets\n" +
                " 22:06 Kill: 2 3 7: Isgalamido killed Mocinha by MOD_ROCKET_SPLASH\n" +
                " 22:11 Item: 2 item_quad\n" +
                " 22:11 ClientDisconnect: 3\n" +
                " 22:18 Kill: 2 2 7: Isgalamido killed Isgalamido by MOD_ROCKET_SPLASH\n" +
                " 22:26 Item: 2 weapon_rocketlauncher\n" +
                " 22:27 Item: 2 ammo_rockets\n" +
                " 22:40 Kill: 2 2 7: Isgalamido killed Isgalamido by MOD_ROCKET_SPLASH\n" +
                " 22:43 Item: 2 weapon_rocketlauncher\n" +
                " 22:45 Item: 2 item_armor_body\n" +
                " 23:06 Kill: 1022 2 22: <world> killed Isgalamido by MOD_TRIGGER_HURT\n" +
                " 23:09 Item: 2 weapon_rocketlauncher\n" +
                " 23:10 Item: 2 ammo_rockets\n" +
                " 23:25 Item: 2 item_health_large\n" +
                " 23:30 Item: 2 item_health_large\n" +
                " 23:32 Item: 2 weapon_rocketlauncher\n" +
                " 23:35 Item: 2 item_armor_body\n" +
                " 23:36 Item: 2 ammo_rockets\n" +
                " 23:37 Item: 2 weapon_rocketlauncher\n" +
                " 23:40 Item: 2 item_armor_shard\n" +
                " 23:40 Item: 2 item_armor_shard\n" +
                " 23:40 Item: 2 item_armor_shard\n" +
                " 23:40 Item: 2 item_armor_combat\n" +
                " 23:43 Item: 2 weapon_rocketlauncher\n" +
                " 23:57 Item: 2 weapon_shotgun\n" +
                " 23:58 Item: 2 ammo_shells\n" +
                " 24:13 Item: 2 item_armor_shard\n" +
                " 24:13 Item: 2 item_armor_shard\n" +
                " 24:13 Item: 2 item_armor_shard\n" +
                " 24:13 Item: 2 item_armor_combat\n" +
                " 24:16 Item: 2 item_health_large\n" +
                " 24:18 Item: 2 ammo_rockets\n" +
                " 24:19 Item: 2 weapon_rocketlauncher\n" +
                " 24:22 Item: 2 item_armor_body\n" +
                " 24:24 Item: 2 ammo_rockets\n" +
                " 24:24 Item: 2 weapon_rocketlauncher\n" +
                " 24:36 Item: 2 item_health_large\n" +
                " 24:43 Item: 2 item_health_mega\n" +
                " 25:05 Kill: 1022 2 22: <world> killed Isgalamido by MOD_TRIGGER_HURT\n" +
                " 25:09 Item: 2 weapon_rocketlauncher\n" +
                " 25:09 Item: 2 ammo_rockets\n" +
                " 25:11 Item: 2 item_armor_body\n" +
                " 25:18 Kill: 1022 2 22: <world> killed Isgalamido by MOD_TRIGGER_HURT\n" +
                " 25:21 Item: 2 weapon_rocketlauncher\n" +
                " 25:22 Item: 2 ammo_rockets\n" +
                " 25:34 Item: 2 weapon_rocketlauncher\n" +
                " 25:41 Kill: 1022 2 19: <world> killed Isgalamido by MOD_FALLING\n" +
                " 25:50 Item: 2 item_armor_combat\n" +
                " 25:52 Kill: 1022 2 22: <world> killed Isgalamido by MOD_TRIGGER_HURT\n" +
                " 25:54 Item: 2 ammo_rockets\n" +
                " 25:55 Item: 2 weapon_rocketlauncher\n" +
                " 25:55 Item: 2 weapon_rocketlauncher\n" +
                " 25:59 Item: 2 item_armor_shard\n" +
                " 25:59 Item: 2 item_armor_shard\n" +
                " 26:05 Item: 2 item_armor_shard\n" +
                " 26:05 Item: 2 item_armor_shard\n" +
                " 26:05 Item: 2 item_armor_shard\n" +
                " 26:09 Item: 2 weapon_rocketlauncher\n" +
                " 26  0:00 ------------------------------------------------------------\n" +
                "  0:00 InitGame: \\sv_floodProtect\\1\\sv_maxPing\\0\\sv_minPing\\0\\sv_maxRate\\10000\\sv_minRate\\0\\sv_hostname\\Code Miner Server\\g_gametype\\0\\sv_privateClients\\2\\sv_maxclients\\16\\sv_allowDownload\\0\\dmflags\\0\\fraglimit\\20\\timelimit\\15\\g_maxGameClients\\0\\capturelimit\\8\\version\\ioq3 1.36 linux-x86_64 Apr 12 2009\\protocol\\68\\mapname\\q3dm17\\gamename\\baseq3\\g_needpass\\0\n" +
                "  0:25 ClientConnect: 2\n" +
                "  0:25 ClientUserinfoChanged: 2 n\\Dono da Bola\\t\\0\\model\\sarge/krusade\\hmodel\\sarge/krusade\\g_redteam\\\\g_blueteam\\\\c1\\5\\c2\\5\\hc\\95\\w\\0\\l\\0\\tt\\0\\tl\\0\n" +
                "  0:27 ClientUserinfoChanged: 2 n\\Mocinha\\t\\0\\model\\sarge\\hmodel\\sarge\\g_redteam\\\\g_blueteam\\\\c1\\4\\c2\\5\\hc\\95\\w\\0\\l\\0\\tt\\0\\tl\\0\n" +
                "  0:27 ClientBegin: 2\n" +
                "  0:29 Item: 2 weapon_rocketlauncher\n" +
                "  0:35 Item: 2 item_armor_shard\n" +
                "  0:35 Item: 2 item_armor_shard\n" +
                "  0:35 Item: 2 item_armor_shard\n" +
                "  0:35 Item: 2 item_armor_combat\n" +
                "  0:38 Item: 2 item_armor_shard\n" +
                "  0:38 Item: 2 item_armor_shard\n" +
                "  0:38 Item: 2 item_armor_shard\n" +
                "  0:55 Item: 2 item_health_large\n" +
                "  0:56 Item: 2 weapon_rocketlauncher\n" +
                "  0:57 Item: 2 ammo_rockets\n" +
                "  0:59 ClientConnect: 3\n" +
                "  0:59 ClientUserinfoChanged: 3 n\\Isgalamido\\t\\0\\model\\xian/default\\hmodel\\xian/default\\g_redteam\\\\g_blueteam\\\\c1\\4\\c2\\5\\hc\\100\\w\\0\\l\\0\\tt\\0\\tl\\0\n" +
                "  1:01 ClientUserinfoChanged: 3 n\\Isgalamido\\t\\0\\model\\uriel/zael\\hmodel\\uriel/zael\\g_redteam\\\\g_blueteam\\\\c1\\5\\c2\\5\\hc\\100\\w\\0\\l\\0\\tt\\0\\tl\\0\n" +
                "  1:01 ClientBegin: 3\n" +
                "  1:02 Item: 3 weapon_rocketlauncher\n" +
                "  1:04 Item: 2 item_armor_shard\n" +
                "  1:04 Item: 2 item_armor_shard\n" +
                "  1:04 Item: 2 item_armor_shard\n" +
                "  1:06 ClientConnect: 4\n" +
                "  1:06 ClientUserinfoChanged: 4 n\\Zeh\\t\\0\\model\\sarge/default\\hmodel\\sarge/default\\g_redteam\\\\g_blueteam\\\\c1\\5\\c2\\5\\hc\\100\\w\\0\\l\\0\\tt\\0\\tl\\0\n" +
                "  1:08 Kill: 3 2 6: Isgalamido killed Mocinha by MOD_ROCKET\n" +
                "  1:08 ClientUserinfoChanged: 4 n\\Zeh\\t\\0\\model\\sarge/default\\hmodel\\sarge/default\\g_redteam\\\\g_blueteam\\\\c1\\1\\c2\\5\\hc\\100\\w\\0\\l\\0\\tt\\0\\tl\\0\n" +
                "  1:08 ClientBegin: 4\n" +
                "  1:10 Item: 3 item_armor_shard\n" +
                "  1:10 Item: 3 item_armor_shard\n" +
                "  1:10 Item: 3 item_armor_shard\n" +
                "  1:10 Item: 3 item_armor_combat\n" +
                "  1:11 Item: 4 weapon_shotgun\n" +
                "  1:11 Item: 4 ammo_shells\n" +
                "  1:16 Item: 4 item_health_large\n" +
                "  1:18 Item: 4 weapon_rocketlauncher\n" +
                "  1:18 Item: 4 ammo_rockets\n" +
                "  1:26 Kill: 1022 4 22: <world> killed Zeh by MOD_TRIGGER_HURT\n" +
                "  1:26 ClientUserinfoChanged: 2 n\\Dono da Bola\\t\\0\\model\\sarge\\hmodel\\sarge\\g_redteam\\\\g_blueteam\\\\c1\\4\\c2\\5\\hc\\95\\w\\0\\l\\0\\tt\\0\\tl\\0\n" +
                "  1:26 Item: 3 weapon_railgun\n" +
                "  1:29 Item: 2 weapon_rocketlauncher\n" +
                "  1:29 Item: 3 weapon_railgun\n" +
                "  1:32 Item: 3 weapon_railgun\n" +
                "  1:32 Kill: 1022 4 22: <world> killed Zeh by MOD_TRIGGER_HURT\n" +
                "  1:35 Item: 2 item_armor_shard\n" +
                "  1:35 Item: 2 item_armor_shard\n" +
                "  1:35 Item: 2 item_armor_shard\n" +
                "  1:35 Item: 3 weapon_railgun\n" +
                "  1:38 Item: 2 item_health_large\n" +
                "  1:38 Item: 3 weapon_railgun\n" +
                "  1:41 Kill: 1022 2 19: <world> killed Dono da Bola by MOD_FALLING\n" +
                "  1:41 Item: 3 weapon_railgun\n" +
                "  1:43 Item: 2 ammo_rockets\n" +
                "  1:44 Item: 2 weapon_rocketlauncher\n" +
                "  1:46 Item: 2 item_armor_shard\n" +
                "  1:47 Item: 2 item_armor_shard\n" +
                "  1:47 Item: 2 item_armor_shard\n" +
                "  1:47 ShutdownGame:\n" +
                "  1:47 ------------------------------------------------------------\n" +
                "  1:47 ------------------------------------------------------------";
    }
}