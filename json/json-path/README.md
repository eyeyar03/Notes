# JSON Path

## Dictionary (Example 1)
```JSON
{
    "car": {
        "color": "blue",
        "price": "$20,000"
    },
    "bus": {
        "color": "white",
        "price": "$120,000"
    }
}
```

### Queries
- Get car details
    ```
    $.car
    ```
  
    Result:
    ```JSON
    [{
      "color": "blue",
      "price": "$20,000"
    }]
    ```

- Get bus details
    ```
    $.bus
    ```

  Result:
    ```JSON
    [{
      "color": "white",
      "price": "$120,000"
    }]
    ```

- Get car color
    ```
    $.car.color
    ```

  Result:
    ```JSON
    ["blue"]
    ```

- Get bus price
    ```
    $.bus.price
    ```

  Result:
    ```JSON
    ["$120,000"]
    ```

---

## Dictionary (Example 2)
```JSON
{
    "vehicles": {
        "car": {
            "color": "blue",
            "price": "$20,000"
        },
        "bus": {
            "color": "white",
            "price": "$120,000"
        }
    }
}
```

### Queries
- Get car details
    ```
    $.vehicles.car
    ```
  Result:
    ```JSON
    [{
      "color": "blue",
      "price": "$20,000"
    }]
    ```

- Get bus details
    ```
    $.vehicles.bus
    ```

  Result:
    ```JSON
    [{
      "color": "white",
      "price": "$120,000"
    }]
    ```

- Get car color
    ```
    $.vehicles.car.color
    ```

  Result:
    ```JSON
    ["blue"]
    ```

- Get bus price
    ```
    $.vehicles.bus.price
    ```

  Result:
    ```JSON
    ["$120,000"]
    ```
  
---

## List
```JSON
[
    "car",
    "bus",
    "truck",
    "bike"
]
```

### Queries
- Get first item
    ```
    $[0]
    ```

  Result:
    ```JSON
    ["car"]
    ```

- Get second and fourth items
    ```
    $[1, 3]
    ```

  Result:
    ```JSON
    ["bus", "bike"]
    ```
  
---

## Dictionary and List
```JSON
{
    "car": {
        "color": "blue",
        "price": "$20,000",
        "wheels": [{
                "model": "X345ERT",
                "location": "front-right"
            }, {
                "model": "X346GRX",
                "location": "front-left"
            }, {
                "model": "X236DEM",
                "location": "rear-right"
            }, {
                "model": "X987XMV",
                "location": "front-left"
            }]
    }
}
```

### Query
- Get model of second wheel
    ```
    $.car.wheels[1].model
    ```

  Result:
    ```JSON
    ["X346GRX"]
    ```

---

## Criteria
```JSON
[
    12,
    43,
    23,
    12,
    56,
    43,
    93,
    32,
    45,
    63,
    27,
    8,
    78
]
```

### Query
- List all numbers greater than 14
    ```
    $[?( @ > 40)]
    ```

  Result:
    ```JSON
    [
      43,
      56,
      43,
      93,
      45,
      63,
      78
    ]
    ```

---

## Dictionary and List and Criteria
```JSON
{
  "car": {
    "color": "blue",
    "price": "$20,000",
    "wheels": [{
      "model": "X345ERT",
      "location": "front-right"
    }, {
      "model": "X346GRX",
      "location": "front-left"
    }, {
      "model": "X236DEM",
      "location": "rear-right"
    }, {
      "model": "X987XMV",
      "location": "front-left"
    }]
  }
}
```

### Query
- Get the model of rear-right wheel
    ```
    $.car.wheels[?(@.location == "rear-right")].model
    ```

  Result:
    ```JSON
    ["X236DEM"]
    ```

---

## Wildcards - Dictionary
```JSON
{
  "car": {
    "color": "blue",
    "price": "$20,000"
  },
  "bus": {
    "color": "white",
    "price": "$120,000"
  }
}
```

### Queries
- Get all colors of all vehicles
    ```
    $.*.color
    ```

  Result:
    ```JSON
    ["blue", "white"]
    ```

- Get all prices of all vehicles
    ```
    $.*.price
    ```

  Result:
    ```JSON
    ["$20,000", "$120,000"]
    ```

---

## Wildcards - List
```JSON
[{
  "model": "X345ERT",
  "location": "front-right"
}, {
  "model": "X346GRX",
  "location": "front-left"
}, {
  "model": "X236DEM",
  "location": "rear-right"
}, {
  "model": "X987XMV",
  "location": "front-left"
}]
```

### Queries
- Get all models of wheels
    ```
    $[*].model
    ```

  Result:
    ```JSON
    ["X345ERT", "X346GRX", "X236DEM", "X987XMV"]
    ```

---

## Notes
- For dictionary use `$`.
- For list use `$[]`.
- `?` - Check if
- `@` - each item
  - `@ == 40`
  - `@ != 40`
  - `@ in [40, 43, 45]`
  - `@ nin [40, 43, 45]`
- `*` - Wildcard

---

## References
- https://kodekloud.com/topic/introduction-to-json-path/
- https://kodekloud.com/topic/json-path-lists/