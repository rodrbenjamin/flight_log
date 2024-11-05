# Flightlog (solution)

Hlavní Maven modul `flightlog` obsahuje backend
- Postavený na Spring Boot, obashuje i webový server
- Backend staticky servíruje i sestavený frontend (Build je uložený v Gitu, není sestavován ze zdrojáků. Frontend používá knihovnu AureliaJS a v současné době build padá.)
- Pokytuje REST rozhraní pro frontend
- Vyžaduje vlastní databázi
- Integruje se na externí službu `club-database`
- Databáze se automaticky inicializuje pomoci Liquibase při spuštění aplikace. Změny se uloží do databáze a při dalším spuětění se nasazují jen nové změny. Zároveň není možné editovat již nasazené soubory. Pro profil local se nasadí i testovací data. (Tento přístup je běžný pro mikroslužby. Zde byl zvolen hlavně pro jeho jednoduchost. Jinak je možné mít více modulů a míst samostatnou aplikaci, která databázové změny přes Liquibase nasazuje. Pak je nasazování pod větší kontrolou.)
