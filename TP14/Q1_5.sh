#!/bin/bash

# Ajouter un script dans le répertoire /etc/cron.daily/ avec les permissions appropriées
sudo touch /etc/cron.daily/debsecan_check
sudo chmod +x /etc/cron.daily/debsecan_check

# Modifier le contenu du script pour exécuter debsecan à 02h30
echo -e "#!/bin/bash\nsudo debsecan" | sudo tee /etc/cron.daily/debsecan_check > /dev/null

# Ajouter une tâche cron pour exécuter le script tous les jours à 02h30
(sudo crontab -l ; echo "30 2 * * * /etc/cron.daily/debsecan_check") | sudo crontab -
