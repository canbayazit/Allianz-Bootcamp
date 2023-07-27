package service;

import model.Branch;

import java.util.List;

public class BranchService {

    public Branch createBranch(String name) {
        Branch branch = new Branch();
        branch.setName(name);
        return branch;
    }


    // initialDataService'de başlangıçta branş havuzu oluşturduk
    // yeni branş ekliceksek bu branşın havuzda olup olmadığını kontrol eden method
    // yoksa havuza ekler varsa eklemez uyarı verir.
    public void createBranchToBranchPool(List<Branch> branchList, String name) {

        Branch branch = new Branch();
        branch.setName(name);
        boolean isExist = false;
        for (Branch br : branchList) {
            if (br.getName().equalsIgnoreCase(branch.getName())) {
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            branchList.add(branch);
        } else {
            System.err.println("branch name is " + branch.getName() + " is already exist");
        }
    }

}
