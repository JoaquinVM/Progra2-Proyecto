package cardGame.cards;

import java.util.ArrayList;
import java.util.List;

import cardGame.Damagable;
import cardGame.Game;

/**
 * Created by Joaco99 on 08/09/2017.
 */

public class CardDatabase {
    private List<Meme> memes = new ArrayList<>();
    private List<Card> spells = new ArrayList<>();
    private Game game;

    private static CardDatabase instance = new CardDatabase();

    public static CardDatabase getInstance() {
        return instance;
    }

    public CardDatabase(){
        initMemes();
        initSpells();
    }

    public void setGame(Game game){
        this.game = game;
    }

    public List<Meme> getMemes() {
        return memes;
    }

    public List<Card> getSpells() {
        return spells;
    }

    public void initSpells() {
        Card aliens = new Card("aliens", 2, game) {
            @Override
            public void ability() {
                game.damageEnemies(1);
            }
        };
        spells.add(aliens);

        Card chuckApproves = new Card("chuck_approves", 5, game) {
            @Override
            public void ability(Meme meme) {
                game.destroy(meme);
            }
        };
        spells.add(chuckApproves);

        Card controlMental = new Card("control_mental", 6, game) {
            @Override
            public void ability(Meme meme) {
                game.control(meme);
            }
        };
        spells.add(controlMental);

        Card crazyPeach = new Card("crazy_peach", 5, game) {
            @Override
            public void ability() {
                game.damageAll(5);
            }
        };
        spells.add(crazyPeach);

        Card magicFriend = new Card("magic_friend", 5, game) {
            @Override
            public void ability() {
                game.heal(game.getPlayer(), 8);
            }
        };
        spells.add(magicFriend);

        Card notBad = new Card("not_bad", 4, game) {
            @Override
            public void ability() {
                game.damageRandomEnemies(2, 3);
            }
        };
        spells.add(notBad);

        Card trumpcito = new Card("trumpcito", 0, game) {
            @Override
            public void ability() {
                game.getPlayer().increaseMana();
                game.summon(getMexicano(game));
            }
        };
        spells.add(trumpcito);

        Card unknown = new Card("unknown", 1, game) {
            @Override
            public void ability(Damagable damagable) {
                game.dealDamage(damagable, 2);
            }
        };
        spells.add(unknown);

        Card vamoACalmarno = new Card("vamo_a_calmarno", 6, game) {
            @Override
            public void ability() {
                game.damageEnemies(4);
            }
        };
        spells.add(vamoACalmarno);

        Card yas = new Card("yas", 3, game) {
            @Override
            public void ability() {
                game.healAllies(2);
            }
        };
        spells.add(yas);

        Card yisus = new Card("yisus", 3, game) {
            @Override
            public void ability() {
                game.resurrect();
            }
        };
        spells.add(yisus);
    }

    public void initMemes() {
        Meme alexis = new Meme("alexis", 5, 5, 5, game);
        alexis.setCharge(true);
        memes.add(alexis);

        Meme bobToronja = new Meme("bob_toronja", 3, 4, 3, game);
        bobToronja.setCharge(true);
        memes.add(bobToronja);


        Meme brianMalaSuerte = new Meme("brian_mala_suerte", 2, 5, 2, game) {
            @Override
            public void ability() {
                game.dealDamage(game.getPlayer(), 3);
            }
        };
        brianMalaSuerte.setCharge(true);
        memes.add(brianMalaSuerte);

        Meme chuckNorris = new Meme("chuck_norris", 6, 6, 6, game) {
            @Override
            public void ability() {
                game.damageEnemies(1);
            }
        };
        chuckNorris.setEndTurn(true);
        memes.add(chuckNorris);

        Meme darthOzman = new Meme("darthoz_man", 4, 3, 2, game) {
            @Override
            public void ability() {
                game.summon(getYoda(game));
                game.summon(getYoda(game));
            }
        };
        memes.add(darthOzman);

        Meme diCaprio = new Meme("di_caprio", 3, 2, 3, game) {
            @Override
            public void ability() {
                game.damageEnemies(1);
            }
        };
        memes.add(diCaprio);

        Meme dockyG = new Meme("docky_g", 4, 3, 6, game);
        dockyG.setFreeze(true);
        memes.add(dockyG);

        Meme doge = new Meme("doge", 1, 1, 2, game);
        doge.setSpellinmune(true);
        memes.add(doge);

        Meme drPickels = new Meme("dr_pickels", 4, 1, 5, game);
        drPickels.setPoisonous(true);
        memes.add(drPickels);

        Meme jeanPaoltter = new Meme("jean_paoltter", 1, 1, 3, game);
        jeanPaoltter.setTaunt(true);
        memes.add(jeanPaoltter);

        Meme kitten = new Meme("kitten", 7, 5, 10, game);
        kitten.setTaunt(true);
        kitten.setSpellinmune(true);
        memes.add(kitten);

        Meme noMeDigas = new Meme("no_me_digas", 3, 2, 1, game);
        noMeDigas.setSpellinmune(true);
        memes.add(noMeDigas);

        Meme pitereElKoala = new Meme("piter_el_koala", 5, 6, 5, game) {
            @Override
            public void ability() {
                game.discard();
            }
        };
        memes.add(pitereElKoala);

        Meme really = new Meme("really", 2, 0, 5, game);
        really.setTaunt(true);
        memes.add(really);

        Meme tommy = new Meme("tommy", 2, 1, 2, game);
        tommy.setPoisonous(true);
        memes.add(tommy);

        Meme uglyface = new Meme("ugly_face", 2, 2, 4, game);
        uglyface.setTaunt(true);
        memes.add(uglyface);

    }

    public Meme getYoda(Game game){
        Meme yoda = new Meme("yoda", 0, 1, 1, game);
        return  yoda;
    }

    public Meme getMexicano(Game game){
        Meme mexican = new Meme("mexican", 0, 1, 1, game);
        return mexican;
    }
}
