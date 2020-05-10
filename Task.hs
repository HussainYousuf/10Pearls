halve xs = splitAt (length xs `div` 2) xs

merge xs [] = xs
merge [] ys = ys
merge (x:xs) (y:ys) 
  | x <= y    = x : merge xs (y:ys)
  | otherwise = y : merge (x:xs) ys

mSort [] = []
mSort (x:xs) 
  | null xs   = [x]
  | otherwise = merge (mSort lower) (mSort upper)
  where 
    halves = halve (x:xs)
    lower  = fst halves
    upper  = snd halves

-- thats it, compare this with the java code
-- run this function in ghci
sort xs = odds ++ evens 
    where
        evens = filter even xs
        odds  = filter odd  xs