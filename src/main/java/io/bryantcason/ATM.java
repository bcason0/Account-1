package io.bryantcason;


import static io.bryantcason.Bank.allAccounts;
import static io.bryantcason.Prompt.*;


public class ATM {

    public void engine() {
        Account currentAccount = null;
        Bank bank = new Bank();
        int usersInt;
        boolean atmRunning  = true;
        welcomeUser();

        while(atmRunning){


            int userChoice = askForInt("Select an option: \n 1. Create Account \n 2. Withdrawal \n 3. Deposit \n " +
                    "4. Transfer \n 5. Check Balance \n 6. Receipt  \n 7. Select Account \n 8. Close Account \n 86. Exit ");

            switch(userChoice){
                case 1:
                    currentAccount = bank.createAccount();
                    break;
                case 2:
                    bank.withdrawal(askForDouble("Enter amount to withdrawal"), currentAccount);
                    break;
                case 3:
                    bank.deposit(askForDouble("Enter amount to deposit"), currentAccount);
                    break;
                case 4:
                    //pick account you're transferring to.
                    usersInt = askForInt("What is the index of your account? Start from 0: ");
                    bank.transfer(currentAccount, allAccounts.get(usersInt), askForDouble("Enter amount to transfer: "));
                    break;
                case 5:
                    giveMessage("Your balance is " + currentAccount.getBalance());
                    break;
                case 6:
                    bank.ledger.logTransactions();
                    break;
                case 7:
                    currentAccount = bank.selectAccount(askForString("Enter the account number: "));
                    break;
                case 8:
                    giveMessage("Closing account ...");
                    bank.closeAccount(currentAccount);
                    break;
                case 86:
                    giveMessage("Exit");
                    atmRunning = false;

            }
        }

    }

    public void welcomeUser(){
        giveMessage("Welcome to Kerry Washington's ATM!\n" +
                ",,,,,,,,,,;#@##@#@@#@#########@@@###########@#@@@@#@@###@####+##++++++++#''''+++++#+++#++++;::::::::\n" +
                ",,,,,,,,,,'#@@@#@###@##########@#############@@@#@@@@#######@##++++++''''+''''+++###+##++++;::::::::\n" +
                ",,,,,,,,::##@@##@@#@#@########@@#############@#@@@@#@##########+##++'+''++++''+#+#+##+##++++::::::::\n" +
                ",,,,,,,,,;#@@@#@#@##@@#######@@#########+######@####@@#######@##+''+'++''+#+'''##+###+##+++#;:::::::\n" +
                ",,,,,,,,:;@@@#@@@@@#@########@########++++####@#@@@##@##+++#+###'+'++'+'''#++''+#+#########+';::::::\n" +
                ",,,,,,,,:'@@@@@#@@@@####@####@########+++++###########@###+#++###+++++++'''#+++'##+##@######+;::::::\n" +
                ",,,,,,,,:+@@@@@@@@@@#######@@@#######+++++++###@##@#####++##++###++'''+''+++##++'@#@#########+;:::::\n" +
                ",,,,,,,::#@@@@@@@@@@#####+@@@########++++++++###@##@#####+#+#++#@#+';++++'+++##+#####@#######+;:::::\n" +
                ",,,,,,,:;@@@@@@@@@@######+@@@########+++++++++###########++##+'+##++'+''+++++#####+##@########':::::\n" +
                ",,,,,,,:'@@@@@@@@@@#######@@########+++++++++++##########+++#+'+##+'+''+++++####+#+#@@###@####':::::\n" +
                ",,,,,,,:#@@@@@@@@@@##@###@#@#######+++++++++++++#######+##++#++'+##+''+'+++##########@#@@@####+;::::\n" +
                ",,,,,,:;#@@@@@@@@@@#@###@@@@#######++++++++++++++######+##+#+#+++###++++++############@@@@####+'::::\n" +
                ",,,,,,,;#@@@@@@@@@#@@######@######+++++++++++++++#######+##++#+++##@+'+++++#####@#@#####@##@##+'::::\n" +
                ",,,,,,:'@@@@@@@@@@#@@@#@@@@#######+++++++'+''+++++#####+++#++'++++###+++++######@@##@##@@@@@###'::::\n" +
                ",,,,,,,+@@@@@@@@@@@@@##@@@@@#####++++++++'''''+++++##+#++'+#++++#++###++#######@######@#@@@####'::::\n" +
                ",,,,,,:+@@@@@@@@@@@@@#@@@@@######+++++++++'''''++++####+'++##+++++####+++#####@#@#@@#@@#@@@#@@#+;:::\n" +
                ",,,,,,:#@@@@@@@@@@@@##@@@@@@#####++++++++''''''++++++#+#'#++#+#+#++####+#+##@@@#@@#@##@@#@@@#@#+;:::\n" +
                ",,,,,,;#@@@@@@@@@@@@##@@@@@@#####+++''''''''''''++++++#+#'+###+#++++#@##'####@@@@@@@@#@@@@@@@@#+;:::\n" +
                ",,,,,:;#@@@@@@@@@#@##@@@@#@@#####+++''''''''''''''++++#++#++###+#++++@@#+###@@@@@@@@@@@@@@@@###+;:::\n" +
                ",,,,,:'#@@@@@@@@#@###@@@@#@######+++'''''''''''''''+++++++++++##+#+++####+##@@@@@#@@@#@@@@@@@@@+;:::\n" +
                ",,,,,,+@#@@@@@@@@@###@@@@#@#####++++''''''''''''''''+++#+'+++#+@#+#+'+#@######@@@@@@#@@@@@@@@@@+;:::\n" +
                ",,,,,:+#@@@@@@@@@####@@@@#@######+++'''''''''''''''''+++#++++++#@#'##++@#@+##@@@@@@@@@@@@@@@@@@#':::\n" +
                ",,,,,:#@@@@@@@@@@##+@@@@@@@######++''''''''''';;''''''+++#++#+#+###+#++#@@#+@#@@@@@@@#@@@@@@@@##+:::\n" +
                ",,,,,:##@@@@@@@@@###@@@@@@@#####+++''''''''';;;;;;'''''+++++++++##@#+#++##@###@@@@@@@@@#@@@@@@@##;::\n" +
                ",,,,,;##@@@@@@@###+#@@@@@@@#####+++'''''''';;;;;;;;''''+++++++#+++###+##+####@@@@@@@@@@@@@@@@@@@#'::\n" +
                ",,,,,;#@@@@@@@@#@#+#@@@@@@@#####+++++####++''';;;;;;;''''+++++###++#####++####@@@@@@@@@@#@@@@@@#@+::\n" +
                ",,,,:'#@@@@@@@#@@###@@@@@@##################++'';;;;;''''+++++++##########+#@##@@@@@@@@@@@@@@@@#@#':\n" +
                ",,,,,+@@@@@@@@@@###@@@@@@@#########++++#######+++';;;;'''''+++++++#+#######+#@#@@@@@@@@@@@@@@@@@#@+:\n" +
                ",,,,:+@@@@@@@@@###@@@@@@@@@######++'''''+++#####+'';;''''''''++++#+###@###@#+###@@@@@@@@@@@@@@@#@@#;\n" +
                ",,,,;#@@@@@@@@@@##@@@@@@@@######++''''+++++++++#++'''''''''''+++##+##############@@@@@@@@@@@@@@@@##'\n" +
                ",,,,;#@@@@@@@@@@@#@@@@@@@@####+++++++++######+++++'''''''''''+++####++##@#@@@#####@@#@@@@@@@@@@@@@@+\n" +
                ",,,,'#@@@@@@@@@###@@@@@@@@####+++++############+++++''''''''+++######++##@#@@#######@@@@@@@@@@@@@@@#\n" +
                ",,,:'@#@@@@@@@@#@##@@@@@@@####++++###@#@@@#####++++++'''''''+++###@@####+@#@#########@@#@@@@@#@#@@@#\n" +
                ",,,:'@#@@@@@@@@##@@@@@@@@@###++++##@@#@@@#+#####++++++'';;''+++###@@@@@#@#+###@#######@@@@@@@@@@@@@@\n" +
                ",,,;+@@@@@@@@@@#@@@@@@@@@@###++++##@#+#@@@#@'##+++++++'';;''++++##@@@@#@@@@#########@#@@@@@@@@@@@@@@\n" +
                ",,,:+#@@@@@@@@@##@@@@@@@@####+++++#@#++#+##+::#+'+++++'';:;'+++###+#@@@@###@@###########@@@@@@@@@@@@\n" +
                ",,,:###@@@@@@@@@#@@@@#@@@####++++++##++###+:;++#++++++';:,;''+++##+####@++#@@##'###@#####@@@@#@@@@@@\n" +
                ",,:;##@@@@@@@@@@#@@@##@@@###+++++++++++++''';;'''''+++';:,:;'''++######+++###++''#######@###@@@@@@@@\n" +
                ",,:;+#@@@@@@@@@@#@@@#@@@####+++++++++'''';;;;'''''++++';,.,:;''''''++''''+'+++'''+####@@#@@@@@@@@@@@\n" +
                ",,:'##@@@@@@@@@@#@@@@@@#####++++'''+++'''''''';'''++++':,..::;;;;''''''';'''''''''+##@@@@@@@@@@@@@@@\n" +
                ",,:'##@@@@@@@@@@#@@@@@######+++'''''''''''';;;;'''++++':,..,:::;;;;''''';;;;;;;;;;'##@#@@@@@@@@@@@@@\n" +
                ",,;'+#@@@@@@@@@@@@@@@@######++'''''''''';;;;;;;'''++++':,.`.,:::::;;;;;;:::::::;;;+@#@@@@@@@@@@@@@@@\n" +
                ",,:'##@@@@@@@@@@@@@@@@@#####++''';;;;;;;;;;;;;;;''++++':,.`.,,:::::::::::,,,,,::;;+@#@@@@@@@@@##@@@@\n" +
                ",,;;#@@@@@@@@@@@@@@@@@@#####++''';;;;;;;:::::;;;''++++':,.`.,,,,,,:::::,,,,,,,,,::#@@@@@@@@@@@@#@@@@\n" +
                ",:;'###@@@@@@@@@@@@@@#@#####++'';;;;::::::::::;;''++++':,``.,,,,,,,,,,,,,,...,,,::#@@@@@@@@@@@@#@@@@\n" +
                ",,;'##@@@@@@@@@@@@@@@#######+++'';;;::::::::::;;''++++':..`.,,,,,,,,,,,,,...,,,,::+@@@@@@@@@@@@#@@@@\n" +
                ",,;'##@@@@@@@@@@@@@@@#######+++'';;;::::::::::;;'++++';,..`..,,,,,,,,,,,...,,,,::;#@@@@@@@@@@@@#@@@@\n" +
                ",:;'#@@@@@@@@@@@@@@@@#@#####+++''';;;:::::::::;;'++++';,..``.,,,,,,,,,,,..,,,,,::;@@@@@@@@@@@@@#@@@@\n" +
                ",:;'##@@@#@@@@@@@@@@@@#;####+++''';;;:::::,:::;;'++++';,..``.,,,,,,,,,,....,,,:::'@@@@@@@@@#@@@#@@@@\n" +
                ",::+##@@@@@@@@@@@@@@@@..####++++'';;;::::::::::;'++++';,..``.,,,,,,,.......,,,:::'@@@@@@@@@#@@@@#@@@\n" +
                ",;:###@@@@@@@@@@@@@@@,.,'###++++''';;;::::::::;;'++++';,..``.,,,,,,,.......,,,::;;@@@@@@@@@@@@@@@@@@\n" +
                ",;:#@@#@@#@@@@@@@@@@@@@@@####++++'';;;::::::::;''++++';:,...,,,,,,,,,...,,,,,::::'@@@@#@@@@@@@@@@@@@\n" +
                ",;;#@@@@##@@@@@@@@@@@@@@@@###++++''';;::::::::;'++++'';::,,,,:,,,,,,,,,,,,,,,:::,;@@@@#@@@#@@@@#@@@@\n" +
                ",;'##@@@#@@@@@@@@@@@@@@@@@###++++''';;;::::::;;'++''''';:::;;:,,.,,,,,,,,,,,,:::##@@@@##@@#@@@@@@@@@\n" +
                ",:+##@#@@@@@@@@@@@@@@@@@@@###++++'''';;;;::::;'++#'+##'';;;:++:...,,,,,,,,,,,::;#@@@#@##@@#@@@@@@@@@\n" +
                ",:+##@@@@@@@@@@@@@@@@@@@@@####++++''';;;;;::;;'++####++'';;'++.....,,,,,,,,::::'@@@@#@@@@#@#@@@@#@@@\n" +
                ":;####@@@@@@@@@@@@@@@@@@@@####++++'''';;;;:;;''++++#####+';::.......,,,,,,::::;+@@@@@@@@@##@@@@@@@@@\n" +
                ":;####@@@@@@@@@@@@@@@@@@@@@###++++''''';;;;;;''+++++++++;:,,........,,,,:::::;;@@@@@@@@@@@@@@@@@@@@@\n" +
                ":'##@##@@@@@@@@@@@@@@@@@@@@###+++++''''';;;;;''+++++++';:,,..........,,,:::::;;@@@@@@#@@@#@@@@@@@@@@\n" +
                ":+#@##@@@@@@@@@@@@@@@@@@@@@###++++++'''''';;'''''+'''';,,,,,........,,,:::::;;;@@@@@@@@@##@@@@@@@@@@\n" +
                ":#@@##@@@@@@@@@@@@@@@@@@@@@###++++++'''''''''''''''';;:,,,:,,......,,,,:::::;;+@@@@@@@@##@@@@@@@@@@@\n" +
                ";###@#@@@@@@@@@@@@@@@@@@@@@@##++++++''''''''''''''';;;,,,,,.....,,,,,,,:::::;;@@@@@@@@###@@@@@@@@@@#\n" +
                "+####@@@@@@#@@@@@@@@@@@@@@@@##++++++++''+''''''''''''';:,,::::,,,,,,,,:::::::;@@@@@@@@###@@@@@@@@@@@\n" +
                "####@#@@@@@@@@@@@@@@@@@@@@@@##+++++++++++'''''+++'''';:;:,,,,::;::,,,::::::::#@@@@@@@@@##@@@@@@@@@@@\n" +
                "####@#@@@@@#@@@@@@@@@@@@@@@@@##+++++++'++''''+++'''';;:;:::,,:,:;;;::,::::::;@@@@@@@#@@###@@@@@@@@@@\n" +
                "@##@@@@@@@@@@@@@@@@@@@@@@@@@@##+++++++++++''++++++'';;;;;:;::::;''';::::::::'@@@@@@@@@@##@#@@@@@@@@+\n" +
                "@@@@#@@@@@@@@@@@@@@@@@@@@@@@@@#+++++++++++++++##++''''';;';;;;''+++;::::::::@@@@@@@@@@@####@@@@@@@#'\n" +
                "#@@@##@@@@@@@@@@@@@@@@@@@@@@@@#+++++++++++++++++############+':,,.,;::::::;'@@@@@@@@@@@##@##@@@@@@#'\n" +
                "@@@@##@@#@@@@@@@@@@@@@@@@@@@@@@#+++++++++++++++++++';;::;::,.`.,,,;::::::;;@@@@@@@@@@@#@@###@@@@@@@#\n" +
                "@@@###@@@@@@@@@@@@@@@@@@@@@@@@@@+#++++++'++'++++++''';,.`:.`,,,,,;::::::;;#@@@@@@@@@@@@#@##@#@@@@@@@\n" +
                "@@@#+#@#@@#@@@@@@@@@@@@@@@@@@@@@@#+++++++++++++++++'';::,::,,:::;;::::::;'@@@@@#@@@@@@@@#@####@@@@@@\n" +
                "@@@++@##@@@@@@@@@@@@@@@@@@@@@@@@@@##++++++++++++++++';;;:;:::::;;::::::;;@@@@@@##@@@@@@@#@######@@@@\n" +
                "#@#+####@@@@@@@@@@@@@@@@@@@@@@@@@@@#++++++++'+++++++'';;;;;;;;;;;::::::;#@@@@@@#@@@@@@@@@#@#####@###\n" +
                "@@++###@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#++++++''++++++++'+''''''';;;:::::;;@@@@@@@#@@@@@@@@@##@@######+\n" +
                "##++###@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#++++++'+++++++++++++++'';;::::::;;#@@@@@@#@@@@@@@@@#@##@####++\n" +
                "#+'#####@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@##+++++'++++'''++++''';;:::::::::;+#@@@@##@@@@@@@@@@#@@###++++\n" +
                "#'+#####@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#++++++'+''''''''';;::::,,,:::::;'#######@@@@@@@@@@@@###+++++\n" +
                "''+####@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@##++++++'''''''';;:::,,,,,,:::::;;+######@############+++++++\n" +
                ";'#+###@#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@###++++'''''';;;:::::,,,,::::::;;'++++##############++++++++\n");

    }



}
