package com.example.magicapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MagicActivity extends AppCompatActivity {
    private GameLogic game;
    private ArrayList<Card> deck1;
    private ArrayList<Card> deck2;
    private TextView currentPhase;
    private TextView player1Name;
    private TextView player2Name;
    private TextView player1Lifepoints;
    private TextView player1LandNum;
    private TextView player1UntappedLandNum;
    private TextView player1HandSize;
    private TextView player1Deck;
    private TextView player1Graveyard;
    private TextView player2Lifepoints;
    private TextView player2HandSize;
    private TextView player2Deck;
    private TextView player2Graveyard;
    private TextView player2TappedLand;
    private Integer player2TappedLandSize;
    private TextView player2UntappedLand;
    private RecyclerView player1Hand;
    private RecyclerView.LayoutManager player1HandLayoutManager;
    private RecyclerView.Adapter player1HandAdapter;
    private RecyclerView player1Land;
    private RecyclerView.LayoutManager player1LandLayoutManager;
    private RecyclerView.Adapter player1LandAdapter;
    private RecyclerView player1Creatures;
    private RecyclerView.LayoutManager player1CreaturesLayoutManager;
    private RecyclerView.Adapter player1CreaturesAdapter;
    private RecyclerView player2Creatures;
    private RecyclerView.LayoutManager player2CreaturesLayoutManager;
    private RecyclerView.Adapter player2CreaturesAdapter;
    private RecyclerView attackers;
    private RecyclerView.LayoutManager attackersLayoutManager;
    private RecyclerView.Adapter attackersAdapter;
    private RecyclerView blockers;
    private RecyclerView.LayoutManager blockersLayoutManager;
    private RecyclerView.Adapter blockersAdapter;
    private Button nextRound;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magic);
        Card card1 = new Land("Forest", "Green");
        Card card2 = new Land("Forest", "Green");
        Card card3 = new Land("Forest", "Green");
        Card card4 = new Land("Forest", "Green");
        Card card5 = new Land("Forest", "Green");
        Card card6 = new Creature("Bond Beetle", "Green", 1, 0, 1);
        Card card7 = new Creature("Hydra", "Green", 8, 8 , 8);
        Card card8 = new Creature("Garruk's Companion", "Green", 2, 3, 2);
        Card card9 = new Creature("Scute Mob", "Green", 1, 1, 1);
        Card card10 = new Creature("Pelkka Wurm", "Green", 7, 7, 7);
        Card cardA = new Land("Forest", "Green");
        Card cardB = new Land("Forest", "Green");
        Card cardC = new Land("Forest", "Green");
        Card cardD = new Land("Forest", "Green");
        Card cardE = new Land("Forest", "Green");
        Card cardF = new Creature("Bond Beetle", "Green", 1, 0, 1);
        Card cardG = new Creature("Hydra", "Green", 8, 8 , 8);
        Card cardH = new Creature("Garruk's Companion", "Green", 2, 3, 2);
        Card cardI = new Creature("Scute Mob", "Green", 1, 1, 1);
        Card cardJ = new Creature("Pelkka Wurm", "Green", 7, 7, 7);
        Card cardK = new Creature("Vigor", "Green", 6, 6, 6);
        this.deck1 = new ArrayList<Card>();
        deck1.add(card1);
        deck1.add(card2);
        deck1.add(card3);
        deck1.add(card4);
        deck1.add(card5);
        deck1.add(card6);
        deck1.add(card7);
        deck1.add(card8);
        deck1.add(card9);
        deck1.add(card10);
        this.deck2 = new ArrayList<Card>();
        deck2.add(cardA);
        deck2.add(cardB);
        deck2.add(cardC);
        deck2.add(cardD);
        deck2.add(cardE);
        deck2.add(cardF);
        deck2.add(cardG);
        deck2.add(cardH);
        deck2.add(cardI);
        deck2.add(cardJ);
        Player player1 = new Player(deck1);
        Player player2 = new Player(deck2);
        this.game = new GameLogic(player1, player2);
        this.createPlayerStats();
        this.createHand();
        this.createPlayer1Land();
        this.createPlayer1Creatures();
        this.createPlayer2Creatures();
        this.createAttackers();
        this.createBlockers();

    }

    private void createPlayerStats() {
        this.player1Name = (TextView) findViewById(R.id.player1_name );
        player1Name.setText("Challenger");

        this.player2Name = (TextView) findViewById(R.id.player2_name );
        player2Name.setText("Planeswalker");

        this.currentPhase = (TextView) findViewById(R.id.current_phase );
        currentPhase.setText("Current Phase \n \n" + game.getRound());

        this.player1Lifepoints = (TextView) findViewById(R.id.player1_lifepoints );
        player1Lifepoints.setText("LifePoints \n" + game.getPlayer(0).getLifePoints().toString());

        this.player1LandNum = (TextView) findViewById(R.id.player1_land_num );
        player1LandNum.setText("Land \n" + game.getPlayer(0).getActiveLandSize().toString());

        this.player1UntappedLandNum = (TextView) findViewById(R.id.player1_untapped_land_num );
        player1UntappedLandNum.setText("Untapped Land \n" + game.getPlayer(0).getUntappedLandSize().toString());

        this.player1HandSize = (TextView) findViewById(R.id.player1_hand_size);
        player1HandSize.setText("Hand \n" + game.getPlayer(0).getHandSize().toString());

        this.player1Deck = (TextView) findViewById(R.id.player1_deck );
        player1Deck.setText("Deck \n" + game.getPlayer(0).getDeckSize().toString());

        this.player1Graveyard = (TextView) findViewById(R.id.player1_graveyard );
        player1Graveyard.setText("Graveyard \n" + game.getPlayer(0).getGraveyardSize().toString());

        this.player2Lifepoints = (TextView) findViewById(R.id.player2_lifepoints );
        player2Lifepoints.setText("Lifepoints \n" + game.getPlayer(1).getLifePoints().toString());

        this.player2HandSize = (TextView) findViewById(R.id.player2_hand_size);
        player2HandSize.setText("Hand \n" + game.getPlayer(1).getHandSize().toString());

        this.player2Deck = (TextView) findViewById(R.id.player2_deck );
        player2Deck.setText("Deck \n" + game.getPlayer(1).getDeckSize().toString());

        this.player2Graveyard = (TextView) findViewById(R.id.player2_graveyard );
        player2Graveyard.setText("Graveyard \n" + game.getPlayer(1).getGraveyardSize().toString());

        this.player2TappedLand = (TextView) findViewById(R.id.player2_tapped_land );
        int allPlayer2Land = game.getPlayer(1).getActiveLandSize();
        int allPlayer2UntappedLand = game.getPlayer(1).getUntappedLandSize();
        this.player2TappedLandSize = (allPlayer2Land - allPlayer2UntappedLand);
        player2TappedLand.setText("Tapped Land \n" + player2TappedLandSize.toString());

        this.player2UntappedLand = (TextView) findViewById(R.id.player2_untapped_land );
        player2UntappedLand.setText("Untapped Land \n" + game.getPlayer(1).getUntappedLandSize().toString());
    }


    private void createPlayer2Creatures() {
        ArrayList<Creature> player2CreaturesRaw = game.getPlayer2Creatures();
        this.player2Creatures = (RecyclerView) findViewById(R.id.player2_creatures);
        this.player2Creatures.setHasFixedSize(true);
        this.player2CreaturesLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        this.player2Creatures.setLayoutManager(player2CreaturesLayoutManager);
        this.player2CreaturesAdapter = new Player2CreaturesAdapter(player2CreaturesRaw);
        this.player2Creatures.setAdapter(player2CreaturesAdapter);
    }

    private void createPlayer1Creatures() {
        ArrayList<Creature> player1CreaturesRaw = game.getPlayer1Creatures();
        this.player1Creatures = (RecyclerView) findViewById(R.id.player1_creatures);
        this.player1Creatures.setHasFixedSize(true);
        this.player1CreaturesLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        this.player1Creatures.setLayoutManager(player1CreaturesLayoutManager);
        this.player1CreaturesAdapter = new Player1CreaturesAdapter(player1CreaturesRaw);
        this.player1Creatures.setAdapter(player1CreaturesAdapter);
    }

    public void createHand(){
        ArrayList<Card> player1HandRaw = game.getPlayer(0).getHand();
        this.player1Hand = (RecyclerView) findViewById(R.id.player1_hand);
        this.player1Hand.setHasFixedSize(true);
        this.player1HandLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        this.player1Hand.setLayoutManager(player1HandLayoutManager);
        this.player1HandAdapter = new Player1HandAdapter(player1HandRaw, this.game);
        this.player1Hand.setAdapter(player1HandAdapter);
        Log.d("Cards: ", game.getPlayer(0).getHandSize().toString() );



    }

    public void createPlayer1Land(){
        ArrayList<Land> player1LandRaw = game.getPlayer(0).getActiveLand();
        this.player1Land = (RecyclerView) findViewById(R.id.player1_land);
        this.player1Land.setHasFixedSize(true);
        this.player1LandLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        this.player1Land.setLayoutManager(player1LandLayoutManager);
        this.player1LandAdapter = new Player1LandAdapter(player1LandRaw);
        this.player1Land.setAdapter(player1LandAdapter);
    }

    public void createAttackers(){
        ArrayList<Creature> attackersRaw = game.getActiveAttackers();
        this.attackers = (RecyclerView) findViewById(R.id.attackers);
        this.attackers.setHasFixedSize(true);
        this.attackersLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        this.attackers.setLayoutManager(attackersLayoutManager);
        this.attackersAdapter = new AttackersAdapter(attackersRaw);
        this.attackers.setAdapter(attackersAdapter);
    }

    public void createBlockers(){
        ArrayList<Creature> blockersRaw = game.getActiveBlockers();
        this.blockers = (RecyclerView) findViewById(R.id.blockers);
        this.blockers.setHasFixedSize(true);
        this.blockersLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        this.blockers.setLayoutManager(blockersLayoutManager);
        this.blockersAdapter = new BlockersAdapter(blockersRaw);
        this.blockers.setAdapter(blockersAdapter);
    }

    public void onPlayableClick(View chosenCard){
        Card cardToPlay = (Card) chosenCard.getTag();
        Log.d("Card: ", cardToPlay.getName() );

        if (game.playable(cardToPlay, game.getPlayer(0))){
            game.playCard(cardToPlay, game.getPlayer(0));
            this.createHand();
            this.createPlayer1Land();
            this.createPlayerStats();
            Toast.makeText(this, cardToPlay.getName() + " played", Toast.LENGTH_SHORT).show();
        } else if (!game.playable(cardToPlay, game.getPlayer(0) ) && (cardToPlay instanceof Creature) ){
            Toast.makeText(this, "Insufficient mana!", Toast.LENGTH_SHORT).show();
        } else if (!game.playable(cardToPlay, game.getPlayer(0) ) && cardToPlay instanceof Land ){
            Toast.makeText(this, "You've already played Land this turn!", Toast.LENGTH_LONG).show();
        }
    }

    public void onAttackClick(View chosenCreature) {
        Creature creatureToAttack = (Creature) chosenCreature.getTag();
        Log.d("Attacker: ", creatureToAttack.getName());
        if (creatureToAttack.getTapped()) {
            Toast.makeText(this, "Creature Tapped!", Toast.LENGTH_SHORT).show();
        } else if (!creatureToAttack.getTapped()) {
            game.addActiveAttacker(creatureToAttack);
            Toast.makeText(this, "Creature now attacking!", Toast.LENGTH_SHORT).show();
            this.createPlayerStats();
            this.createAttackers();
            this.createPlayer1Creatures();
        }
    }

    public void onNextPhaseClick(View button){
        if (game.isGameover()){
            if (game.getPlayer(0).isDead() ){
                Toast.makeText(this, "You lost! Better luck next time.", Toast.LENGTH_LONG).show();
                Player player1 = new Player(deck1);
                Player player2 = new Player(deck2);
                this.game = new GameLogic(player1, player2);
            } else if (game.getPlayer(1).isDead()){
                Toast.makeText(this, "Well done, you won!", Toast.LENGTH_LONG).show();
                Player player1 = new Player(deck1);
                Player player2 = new Player(deck2);
                this.game = new GameLogic(player1, player2);
            }
        } else if (game.getRound() == "Main"){
            game.nextRound();
            this.createPlayerStats();
            this.createHand();
            this.createPlayer1Land();
            this.createPlayer1Creatures();
            this.createPlayer2Creatures();
            this.createAttackers();
            this.createBlockers();
        } else if (game.getRound() == "Attack") {
            int damage = game.attack(game.getPlayer(1));
            Toast.makeText(this, "You did " + damage + " damage!", Toast.LENGTH_LONG).show();
            game.nextRound();
            this.createPlayerStats();
            this.createHand();
            this.createPlayer1Land();
            this.createPlayer1Creatures();
            this.createPlayer2Creatures();
            this.createAttackers();
            this.createBlockers();
        } else if (game.getRound() == "Block"){
            game.nextRound();
            this.createPlayerStats();
            this.createHand();
            this.createPlayer1Land();
            this.createPlayer1Creatures();
            this.createPlayer2Creatures();
            this.createAttackers();
            this.createBlockers();
        } else if (game.getRound() == "Damage"){
            game.nextRound();
            this.createPlayerStats();
            this.createHand();
            this.createPlayer1Land();
            this.createPlayer1Creatures();
            this.createPlayer2Creatures();
            this.createAttackers();
            this.createBlockers();
        } else if (game.getRound() == "End"){
            game.nextRound();
            this.createPlayerStats();
            this.createHand();
            this.createPlayer1Land();
            this.createPlayer1Creatures();
            this.createPlayer2Creatures();
            this.createAttackers();
            this.createBlockers();
        } else if (game.getRound() == "Swap"){
            game.swap();
            if (game.getActivePlayer() == game.getPlayer(1)){
                game.computerTurn();
                game.swap();
                this.createPlayerStats();
                this.createHand();
                this.createPlayer1Land();
                this.createPlayer1Creatures();
                this.createPlayer2Creatures();
                this.createAttackers();
                this.createBlockers();
            }
        }
    }
}



