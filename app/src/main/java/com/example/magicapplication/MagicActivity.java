package com.example.magicapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

public class MagicActivity extends AppCompatActivity {
    private GameLogic game;
    private TextView player1Name;
    private TextView player2Name;
    private TextView player1Lifepoints;
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
    private RecyclerView attackers;
    private RecyclerView.LayoutManager attackersLayoutManager;
    private RecyclerView.Adapter attackersAdapter;
    private RecyclerView blockers;
    private RecyclerView.LayoutManager blockersLayoutManager;
    private RecyclerView.Adapter blockersAdapter;


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
        ArrayList<Card> deck1 = new ArrayList<Card>();
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
        ArrayList<Card> deck2 = new ArrayList<Card>();
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
//        Add a name to Players!
        this.player1Name = (TextView) findViewById(R.id.player1_name );
        player1Name.setText("Challenger");

        this.player2Name = (TextView) findViewById(R.id.player2_name );
        player2Name.setText("Planeswalker");

        this.player1Lifepoints = (TextView) findViewById(R.id.player1_lifepoints );
        player1Lifepoints.setText(game.getPlayer(0).getLifePoints().toString());

        this.player1HandSize = (TextView) findViewById(R.id.player1_hand_size);
        player1HandSize.setText(game.getPlayer(0).getHandSize().toString());

        this.player1Deck = (TextView) findViewById(R.id.player1_deck );
        player1Deck.setText(game.getPlayer(0).getDeckSize().toString());

        this.player1Graveyard = (TextView) findViewById(R.id.player1_grave );
        player1Graveyard.setText(game.getPlayer(0).getGraveyardSize().toString());

        this.player2Lifepoints = (TextView) findViewById(R.id.player2_lifepoints );
        player2Lifepoints.setText(game.getPlayer(1).getLifePoints().toString());

        this.player2HandSize = (TextView) findViewById(R.id.player2_hand_size);
        player2HandSize.setText(game.getPlayer(1).getHandSize().toString());

        this.player2Deck = (TextView) findViewById(R.id.player2_deck );
        player2Deck.setText(game.getPlayer(1).getDeckSize().toString());

        this.player2Graveyard = (TextView) findViewById(R.id.player2_graveyard );
        player2Graveyard.setText(game.getPlayer(1).getGraveyardSize().toString());

        this.player2TappedLand = (TextView) findViewById(R.id.player2_tapped_land );
        int allPlayer2Land = game.getPlayer(1).getActiveLandSize();
        int allPlayer2UntappedLand = game.getPlayer(1).getUntappedLandSize();
        this.player2TappedLandSize = (allPlayer2Land - allPlayer2UntappedLand);
        player2TappedLand.setText(player2TappedLandSize.toString());

        this.player2UntappedLand = (TextView) findViewById(R.id.player2_untapped_land );
        player2UntappedLand.setText(game.getPlayer(1).getUntappedLandSize().toString());

        ArrayList<Card> player1HandRaw = game.getPlayer(0).getHand();
        ArrayList<Land> player1LandRaw = game.getPlayer(0).getActiveLand();
        ArrayList<Creature> player1CreaturesRaw = game.getPlayer1Creatures();
        ArrayList<Creature> attackersRaw = game.getActiveAttackers();
        ArrayList<Creature> blockersRaw = game.getActiveBlockers();


        player1Hand = (RecyclerView) findViewById(R.id.player1_hand);
        player1Hand.setHasFixedSize(true);
        player1HandLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        player1Hand.setLayoutManager(player1HandLayoutManager);
        player1HandAdapter = new Player1HandAdapter(player1HandRaw);
        player1Hand.setAdapter(player1HandAdapter);

        player1Land = (RecyclerView) findViewById(R.id.player1_land);
        player1Land.setHasFixedSize(true);
        player1LandLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        player1Land.setLayoutManager(player1LandLayoutManager);
        player1LandAdapter = new Player1LandAdapter(player1LandRaw);
        player1Land.setAdapter(player1LandAdapter);

        player1Creatures = (RecyclerView) findViewById(R.id.player1_creatures);
        player1Creatures.setHasFixedSize(true);
        player1CreaturesLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        player1Creatures.setLayoutManager(player1CreaturesLayoutManager);
        player1CreaturesAdapter = new Player1CreaturesAdapter(player1CreaturesRaw);
        player1Creatures.setAdapter(player1CreaturesAdapter);

        attackers = (RecyclerView) findViewById(R.id.attackers);
        attackers.setHasFixedSize(true);
        attackersLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        attackers.setLayoutManager(attackersLayoutManager);
        attackersAdapter = new AttackersAdapter(attackersRaw);
        attackers.setAdapter(attackersAdapter);

        blockers = (RecyclerView) findViewById(R.id.blockers);
        blockers.setHasFixedSize(true);
        blockersLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        blockers.setLayoutManager(blockersLayoutManager);
        blockersAdapter = new BlockersAdapter(blockersRaw);
        blockers.setAdapter(blockersAdapter);

    }



}
