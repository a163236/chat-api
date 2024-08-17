# How to use

## Before starting

Start MySQL server

https://github.com/Akitsu-Lab/chat-db/blob/main/keita-memo.md

Example

```shell
docker compose -f ../chat-db/docker-compose.yml up --build -d
```

## Start API server

```shell
./gradlew bootRun
```

## Build jar

```shell
./gradlew build
```

## Recommendation

Postman for API testing

https://www.postman.com/downloads/

# JdbcClientについて

- クエリの実行: sql()メソッドでSQLを指定し、param()メソッドでパラメータをセットします。
- 結果の取得: query()メソッドを使用してクエリを実行し、singleResult()やlistResult()で結果を取得します。
- 更新の実行: update()メソッドでデータの挿入や更新を行います。

```
jdbcClient.sql("SELECT * FROM chatrooms")
                .query()
                .listOfRows()
                .stream()
                .map(row -> new Chatroom((int) row.get("room_id"), (String) row.get("room_name"))).toList();
```