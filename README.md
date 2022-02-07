# Описание скрипта

SonarQube — платформа с открытым исходным кодом для непрерывного анализа и измерения качества программного кода. 

Скрипт позволяет устанавить:
```
1. postgresql
2. bitnami/sonarqube
3. cadvisor
```
Дополнительне диски для данных:
```
volumes:
  postgresql_data:
    driver: local
    name: postgresqlstorage
    driver_opts:
      type: "ext4"
      device: "/dev/vdb"
  sonarqube_data:
    driver: local
    name: sonarqubestorage
    driver_opts:
      type: "ext4"
      device: "/dev/vdc"
```
## Инструкция по применению: 

1. Настроить машину
2. Добавить диски и смонтировать по Lable:
```
fdisk -l
mkfs.ext4 /dev/vdg
e2label /dev/vdg grafana # Lable
echo "LABEL=grafana /mnt/grafana ext4 lazytime,discard 0 2" | sudo tee -a /etc/fstab
...
...
...
```
3. Устанавить docker и docker-compose
https://github.com/izobretatel9/docker
4. Задать и добавить виртуальную память на хост
```
echo "vm.max_map_count=262144" | sudo tee -a /etc/sysctl.conf
```

5. Изменить docker-compose.yml для этого репозитория и запустить
## Дполнительные информация: 

1. "stages.groovy" содержит stages для pipline в Jenkins. Для плагина sonnar-scanner
https://docs.sonarqube.org/latest/analysis/scan/sonarscanner-for-jenkins/
2. Вход в дефолтную админку:
```
login = admin  
password = bitnami
```
## P.s Изначальный создатель скрипта

@izobretatel9
## Источник образов
```
https://hub.docker.com/r/bitnami/sonarqube/
https://github.com/bitnami/bitnami-docker-sonarqube
```
