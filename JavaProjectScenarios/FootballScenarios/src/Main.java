import model.*;
import service.PlayerService;
import service.TeamService;
import service.TransferService;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        TeamService teamService = new TeamService();
        PlayerService playerService = new PlayerService();
        TransferService transferService = new TransferService();

        Team team = teamService.createTeam("Galatasaray", "GS", "yellow-red",
                "Okan Buruk", "Dursun Özbek", "Nef Arena", new BigDecimal(400)
                 );

        teamService.addAwardToTeam(team, "Champions Cup", 2023,
                AwardTypeEnum.CUP);


        Team team2 = teamService.createTeam("Fenerbahçe", "FB", "yellow-blue",
                "İsmail Kartal", "Ali Koç", "Kadıköy", new BigDecimal(800));


        teamService.addAwardToTeam(team2, "Turkish Cup", 2023,
                AwardTypeEnum.CUP);

        teamService.addAwardToTeam(team, "League Cup", 2023,
                AwardTypeEnum.CUP);


        Player player = playerService.createPlayer("Cristiano", "Ronaldo",
                7, 1985, "Forvet", new BigDecimal(100));

        playerService.addTeamToPlayer(player, team);

        Transfer transfer = transferService.makeTransfer(player, team2);

        playerService.addTransferHistoryToPlayer(player, transfer);


        System.out.println("Satan takım: " + team);
        System.out.println("Alan takım: " + team2);
        System.out.println("Oyuncu: " + player);
        System.out.println("Transfer ücreti: " + transfer.getPrice());






    }






}