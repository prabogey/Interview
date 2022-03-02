def findPotentialInsiderTraders(datafeed):
    flagged = set()
    trades = dict()
    lastClosePrice = -1
    for feed in datafeed:
        data = feed.split("|")
        day = int(data[0])
        if len(data) > 2:
            name = data[1]
            buy = false if len(data[2]) == 4 else true
            amount = int(data[3])
            if day not in trades:
                trades[day] = []
            trades[day].append((name, buy, price, amount))     

        else:
            price = int(data[1])
            for x in range(day - 3, day):
                if x in trades:
                    for (name, buy, price, amount) in trades[x]:
                        if (x, trader_name) in flagged:
                            continue
                        elif isBuy:
                            fraud = (price - lastClosePrice) * amount >= 500000
                        else:
                            fraud = (lastClosePrice - price) * amount >= 500000
                        if fraud:
                            flagged.add((x, trader_name))
            
    flagged = sorted(list(flagged))
    return list(map(lambda x: str(x[0]) + "|" + str(x[1]), flagged))