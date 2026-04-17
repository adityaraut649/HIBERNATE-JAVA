package com.kodnest.OneToMan;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter player name ,email , phone and height");
		Player player = new Player(sc.next(), sc.next(), sc.next(), sc.nextFloat());

		ArrayList<Game> gamelist = new ArrayList<>();

		System.out.println("Enter number of games");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("enter games name and location  for game" + i);
			gamelist.add(new Game(sc.next(), sc.next()));
		}

		for (int i = 0; i < gamelist.size(); i++) {
			gamelist.get(i).setPlayer(player);
		}

		player.setGames(gamelist);

		// Hibernate steps

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		session.persist(player);
		transaction.commit();
		session.close();
		factory.close();
	}
}
