package cardGame.cards;

import java.util.ArrayList;
import java.util.List;

import cardGame.Damagable;
import cardGame.Game;

/**
 * Created by Joaco99 on 08/09/2017.
 */

public class CardDatabase {
    List<Card> list = new ArrayList<>();

    CardDatabase instance = new CardDatabase();

    public CardDatabase getInstance() {
        return instance;
    }

    public void initSpells(Game game) {
        Card aliens = new Card("aliens", 2, game) {
            @Override
            public void ability() {
                game.damageEnemies(1);
            }
        };
        list.add(aliens);

        Card chuckApproves = new Card("chuck_approves", 5, game) {
            @Override
            public void ability(Meme meme) {
                game.destroy(meme);
            }
        };
        list.add(chuckApproves);

        Card controlMental = new Card("control_mental", 6, game) {
            @Override
            public void ability(Meme meme) {
                game.control(meme);
            }
        };
        list.add(controlMental);

        Card crazyPeach = new Card("crazy_peach", 5, game) {
            @Override
            public void ability() {
                game.damageAll(5);
            }
        };
        list.add(crazyPeach);

        Card magicFriend = new Card("magic_friend", 5, game) {
            @Override
            public void ability() {
                game.heal(game.getPlayer(), 8);
            }
        };
        list.add(magicFriend);

        Card notBad = new Card("not_bad", 4, game) {
            @Override
            public void ability() {
                game.damageRandomEnemies(2, 3);
            }
        };
        list.add(notBad);

        Card trumpcito = new Card("trumpcito", 0, game) {
            @Override
            public void ability() {
                game.getPlayer().increaseMana();
                //TODO complete
                //game.getPlayer().summon();
            }
        };
        list.add(trumpcito);

        Card unknown = new Card("unknown", 1, game) {
            @Override
            public void ability(Damagable damagable) {
                game.dealDamage(damagable, 2);
            }
        };
        list.add(unknown);

        Card vamoACalmarno = new Card("vamo_a_calmarno", 6, game) {
            @Override
            public void ability() {
                game.damageEnemies(4);
            }
        };
        list.add(vamoACalmarno);

        Card yas = new Card("yas", 3, game) {
            @Override
            public void ability() {
                game.healAllies(2);
            }
        };
        list.add(yas);

        Card yisus = new Card("yisus", 3, game) {
            @Override
            public void ability() {
                game.resurrect();
            }
        };
        list.add(yisus);
    }

    public void initMemes(Game game) {
        Meme alexis = new Meme("alexis", 5, 5, 5, game);
        alexis.setCharge(true);

        Meme bobToronja = new Meme("bob_toronja", 3, 4, 3, game);
        bobToronja.setCharge(true);

        Meme brianMalaSuerte = new Meme("brian_mala_suerte", 2, 5, 2, game) {
            @Override
            public void ability() {
                game.dealDamage(game.getPlayer(), 3);
            }
        };
        brianMalaSuerte.setCharge(true);

        Meme chuckNorris = new Meme("chuck_norris", 6, 6, 6, game) {
            @Override
            public void ability() {
                game.damageEnemies(1);
            }
        };

        Meme darthOzman = new Meme("darthoz_man", 4, 3, 2, game) {
            @Override
            public void ability() {
                //game.getPlayer().summon(d);
                //TODO
            }
        };

        Meme diCaprio = new Meme("di_caprio", 3, 2, 3, game) {
            @Override
            public void ability() {
                game.damageEnemies(1);
            }
        };

        Meme dockyG = new Meme("docky_g", 4, 3, 6, game);
        dockyG.setFreeze(true);

        Meme doge = new Meme("doge", 1, 1, 2, game);
        doge.setSpellinmune(true);

        Meme drPickels = new Meme("dr_pickels", 4, 1, 5, game);
        drPickels.setPoisonous(true);

        Meme jeanPaoltter = new Meme("jean_paoltter", 1, 1, 3, game);
        jeanPaoltter.setTaunt(true);

        Meme kitten = new Meme("kitten", 7, 5, 10, game);
        kitten.setTaunt(true);
        kitten.setSpellinmune(true);

        Meme mexican = new Meme("mexican", 0, 1, 1, game);

        Meme noMeDigas = new Meme("no_me_digas", 3, 2, 1, game);
        noMeDigas.setSpellinmune(true);

        Meme pitereElKoala = new Meme("piter_el_koala", 5, 6, 5, game) {
            @Override
            public void ability() {
                game.discard();
            }
        };

        Meme really = new Meme("really", 2, 0, 5, game);
        really.setTaunt(true);

        Meme tommy = new Meme("tommy", 2, 1, 2, game);
        tommy.setPoisonous(true);

        Meme uglyface = new Meme("ugly_face", 2, 2, 4, game);
        uglyface.setTaunt(true);

        Meme yoda = new Meme("yoda", 0, 1, 1, game);


    }
}
