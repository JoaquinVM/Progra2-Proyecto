package cardGame.cards;

import java.util.ArrayList;

import cardGame.Game;

/**
 * Created by Joaco99 on 08/09/2017.
 */

public class CardDatabase {
    ArrayList<Card> list = new ArrayList<>();

    CardDatabase instance = new CardDatabase();

    public CardDatabase getInstance() {
        return instance;
    }

    public void initSpells(Game game){
        Card aliens = new Card("aliens", 2, game){
            @Override
            public void ability(Meme m) {
                game.damageEnemies(1);
            }
        };

        Card chuckApproves = new Card("chuck_approves", 5, game){
            @Override
            public void ability(Meme  m) {
                game.destroy(m);
            }
        };

        Card controlMental = new Card("control_mental", 6, game){
            @Override
            public void ability(Meme meme) {
                game.control(meme);
            }
        };

        Card crazyPeach = new Card("crazy_peach", 5, game){
            @Override
            public void ability(Meme meme) {
                game.damageAll(5);
            }
        };

        Card magicFriend = new Card("magic_friend", 5, game){
            @Override
            public void ability(Meme meme) {
                game.heal(game.getPlayer(), 8);
            }
        };
    }
}
