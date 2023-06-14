package com.justeryt.discordbot.commands.Parsing;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rank {
    static Map<String, String> rankImages = new HashMap<>();

    public Rank() {
        rankImages.put("Herald I", "https://gamepedia.cursecdn.com/dota2_gamepedia/thumb/8/85/SeasonalRank1-1.png/140px-SeasonalRank1-1.png?version=ce7c6eea36971495cdad1f06e7ef3709");
        rankImages.put("Herald II", "https://gamepedia.cursecdn.com/dota2_gamepedia/thumb/e/ee/SeasonalRank1-2.png/140px-SeasonalRank1-2.png?version=094dc352040053ea02f1bbb82a4591f1");
        rankImages.put("Herald III", "https://gamepedia.cursecdn.com/dota2_gamepedia/thumb/0/05/SeasonalRank1-3.png/140px-SeasonalRank1-3.png?version=529b1f8ac23899b14bb30b03036d277e");
        rankImages.put("Herald IV", "https://gamepedia.cursecdn.com/dota2_gamepedia/thumb/6/6d/SeasonalRank1-4.png/140px-SeasonalRank1-4.png?version=e5fa236efcfc108987fac807d890771d");
        rankImages.put("Herald V", "https://gamepedia.cursecdn.com/dota2_gamepedia/thumb/2/2b/SeasonalRank1-5.png/140px-SeasonalRank1-5.png?version=c33004c635c667fa661fad0e2593869e");

        rankImages.put("Guardian I", "https://gamepedia.cursecdn.com/dota2_gamepedia/thumb/c/c7/SeasonalRank2-1.png/140px-SeasonalRank2-1.png?version=832ba8a7042450ebf2cee3209e2cfac8");
        rankImages.put("Guardian II", "https://gamepedia.cursecdn.com/dota2_gamepedia/thumb/2/2c/SeasonalRank2-2.png/140px-SeasonalRank2-2.png?version=be558245d8ddcb6479277d684956aea9");
        rankImages.put("Guardian III", "https://gamepedia.cursecdn.com/dota2_gamepedia/thumb/f/f5/SeasonalRank2-3.png/140px-SeasonalRank2-3.png?version=38233a7123c0b90df8872a6b9a04a87c");
        rankImages.put("Guardian IV", "https://gamepedia.cursecdn.com/dota2_gamepedia/thumb/b/b4/SeasonalRank2-4.png/140px-SeasonalRank2-4.png?version=879bc97952e7acbbb4cb76df1618757a");
        rankImages.put("Guardian V", "https://gamepedia.cursecdn.com/dota2_gamepedia/thumb/3/32/SeasonalRank2-5.png/140px-SeasonalRank2-5.png?version=5b99be61ba7db96bfdc03a9fef6f1fb4");

        rankImages.put("Crusader I", "https://gamepedia.cursecdn.com/dota2_gamepedia/thumb/8/82/SeasonalRank3-1.png/140px-SeasonalRank3-1.png?version=b9a19f0189fe0236ee00fb94cc97a693");
        rankImages.put("Crusader II", "https://gamepedia.cursecdn.com/dota2_gamepedia/thumb/6/6e/SeasonalRank3-2.png/140px-SeasonalRank3-2.png?version=8e03bbb7be665bcadcb0913eaecee2c0");
        rankImages.put("Crusader III", "https://gamepedia.cursecdn.com/dota2_gamepedia/thumb/6/67/SeasonalRank3-3.png/140px-SeasonalRank3-3.png?version=59df65f46dbfc05c7dcb5d877aa2f37c");
        rankImages.put("Crusader IV", "https://gamepedia.cursecdn.com/dota2_gamepedia/thumb/8/87/SeasonalRank3-4.png/140px-SeasonalRank3-4.png?version=8582a808c060a4df95385c98844e666b");
        rankImages.put("Crusader V", "https://gamepedia.cursecdn.com/dota2_gamepedia/thumb/b/b1/SeasonalRank3-5.png/140px-SeasonalRank3-5.png?version=4f0db8503ae24ddd488374b6e5968daf");

        rankImages.put("Archon I", "https://gamepedia.cursecdn.com/dota2_gamepedia/thumb/7/76/SeasonalRank4-1.png/140px-SeasonalRank4-1.png?version=7a9db7f22e02de4a58923f40da38b9db");
        rankImages.put("Archon II", "https://gamepedia.cursecdn.com/dota2_gamepedia/thumb/8/87/SeasonalRank4-2.png/140px-SeasonalRank4-2.png?version=358a9043ef264bcb2ea3424339ac671a");
        rankImages.put("Archon III", "https://gamepedia.cursecdn.com/dota2_gamepedia/thumb/6/60/SeasonalRank4-3.png/140px-SeasonalRank4-3.png?version=3e5c81e69f244b6028ef27beb0fc3ec6");
        rankImages.put("Archon IV", "https://gamepedia.cursecdn.com/dota2_gamepedia/thumb/4/4a/SeasonalRank4-4.png/140px-SeasonalRank4-4.png?version=aacf3fb098fb8de1c514d73b7a0f63c7");
        rankImages.put("Archon V", "https://gamepedia.cursecdn.com/dota2_gamepedia/thumb/a/a3/SeasonalRank4-5.png/140px-SeasonalRank4-5.png?version=7b207bd7de3fe423117f6ea7331dfc88");

        rankImages.put("Legend I", "https://gamepedia.cursecdn.com/dota2_gamepedia/thumb/7/79/SeasonalRank5-1.png/140px-SeasonalRank5-1.png?version=7742371d2571ee59b59c6ac14e5688fa");
        rankImages.put("Legend II", "https://gamepedia.cursecdn.com/dota2_gamepedia/thumb/5/52/SeasonalRank5-2.png/140px-SeasonalRank5-2.png?version=204da548015c1947ce514c8ac81c99ea");
        rankImages.put("Legend III", "https://gamepedia.cursecdn.com/dota2_gamepedia/thumb/8/88/SeasonalRank5-3.png/140px-SeasonalRank5-3.png?version=990f1323b00256eb84002ab050b9188b");
        rankImages.put("Legend IV", "https://gamepedia.cursecdn.com/dota2_gamepedia/thumb/2/25/SeasonalRank5-4.png/140px-SeasonalRank5-4.png?version=0248fc56651cc810ddceca901386322a");
        rankImages.put("Legend V", "https://gamepedia.cursecdn.com/dota2_gamepedia/thumb/8/8e/SeasonalRank5-5.png/140px-SeasonalRank5-5.png?version=14dc5ce669daf93b178350a0b3ee27e1");

        rankImages.put("Ancient I", "https://gamepedia.cursecdn.com/dota2_gamepedia/thumb/e/e0/SeasonalRank6-1.png/140px-SeasonalRank6-1.png?version=56f4415e7d8fc83168c03f374e7babbc");
        rankImages.put("Ancient II", "https://gamepedia.cursecdn.com/dota2_gamepedia/thumb/1/1c/SeasonalRank6-2.png/140px-SeasonalRank6-2.png?version=87515796db90be81886c62cad9faf87f");
        rankImages.put("Ancient III", "https://gamepedia.cursecdn.com/dota2_gamepedia/thumb/d/da/SeasonalRank6-3.png/140px-SeasonalRank6-3.png?version=190512e1572f037b0936f8b1a4bb55b6");
        rankImages.put("Ancient IV", "https://gamepedia.cursecdn.com/dota2_gamepedia/thumb/d/db/SeasonalRank6-4.png/140px-SeasonalRank6-4.png?version=aba16fcff849cb2495f1ddc25bfefd74");
        rankImages.put("Ancient V", "https://gamepedia.cursecdn.com/dota2_gamepedia/thumb/4/47/SeasonalRank6-5.png/140px-SeasonalRank6-5.png?version=1ae82223757486aa55461a82fa09ac6a");

        rankImages.put("Divine I", "https://gamepedia.cursecdn.com/dota2_gamepedia/thumb/b/b7/SeasonalRank7-1.png/140px-SeasonalRank7-1.png?version=8cd74e57b63ceb730d7b36a8f6589b9f");
        rankImages.put("Divine II", "https://gamepedia.cursecdn.com/dota2_gamepedia/thumb/8/8f/SeasonalRank7-2.png/140px-SeasonalRank7-2.png?version=59d74d77a554732a99debd54d1b1b641");
        rankImages.put("Divine III", "https://gamepedia.cursecdn.com/dota2_gamepedia/thumb/f/fd/SeasonalRank7-3.png/140px-SeasonalRank7-3.png?version=12f7e65e8c858b1d39e2a4a17bc85522");
        rankImages.put("Divine IV", "https://gamepedia.cursecdn.com/dota2_gamepedia/thumb/1/13/SeasonalRank7-4.png/140px-SeasonalRank7-4.png?version=247aba452307e17cd6f647321450b8a5");
        rankImages.put("Divine V", "https://gamepedia.cursecdn.com/dota2_gamepedia/thumb/3/33/SeasonalRank7-5.png/140px-SeasonalRank7-5.png?version=0db40597d94b70e3619c2a3e80317e94");

        rankImages.put("Immortal", "https://gamepedia.cursecdn.com/dota2_gamepedia/d/df/SeasonalRankTop1.png?version=8cdf908cc8a9100daa7449ed11550504");
        rankImages.put("Immortal1", "https://gamepedia.cursecdn.com/dota2_gamepedia/a/ad/SeasonalRankTop2.png?version=89000c52fcb08e0ccafec82a886e26fc");
        rankImages.put("Immortal2", "https://gamepedia.cursecdn.com/dota2_gamepedia/thumb/8/8e/SeasonalRankTop3.png/140px-SeasonalRankTop3.png?version=2d5ac3bc228dc44b522db42d0dd5ae1c");

    }

    public Map<String, String> getRankImages() {
        return rankImages;
    }

    public String extractRank(String phrase) {
        Pattern pattern = Pattern.compile("Rank:\\s*(?:#(\\d+)\\s*-\\s*)?(.*)");
        Matcher matcher = pattern.matcher(phrase);

        if (matcher.find()) {
            String rankNumberString = matcher.group(1);
            String rankName = matcher.group(2);

            if (rankNumberString != null && !rankNumberString.isEmpty()) {
                int rankNumber = Integer.parseInt(rankNumberString);
                if (rankNumber >= 0 && rankNumber <= 10) {
                    // Используем картинку из Image 1
                    return "Immortal2";
                } else if (rankNumber >= 11 && rankNumber <= 100) {
                    // Используем картинку из Image 2
                    return "Immortal1";
                } else if (rankNumber >= 101 && rankNumber <= 5000) {
                    // Используем картинку из Image 3
                    return "Immortal";
                }
            }

            return rankName;
        }

        return null;
    }
}

