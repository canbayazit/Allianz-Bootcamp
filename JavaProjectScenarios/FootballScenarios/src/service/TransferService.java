package service;

import model.Player;
import model.Team;
import model.Transfer;

import java.math.BigDecimal;

public class TransferService {

    public Transfer makeTransfer(Player player, Team toTeam) {


        if (toTeam.getBudget().compareTo(player.getValue()) >= 0) {
            System.out.println("transfer can bo done");
            toTeam.setBudget(toTeam.getBudget().subtract(player.getValue()));
            // team listten' oyuncunun son takımını aldık (son takımı mevcut takımı oluyor aslında)
            // bunu Team tipinde bir değişkene setledik
            // çünkü getTeamList Team tipinde bir arraylist.
            Team fromTeam = player.getTeamList().get(player.getTeamList().size() - 1);

            fromTeam.setBudget(fromTeam.getBudget().add(player.getValue()));
            player.getTeamList().add(toTeam);

        } else {
            System.err.println("transfer can not be done because of not enough budget");
        }

        Transfer transfer = new Transfer();
        transfer.setPrice(player.getValue());
        transfer.setFromTeam(player.getTeamList().get(player.getTeamList().size() - 1));
        transfer.setToTeam(toTeam);
        transfer.setYear(2023);

        return transfer;
    }

}
