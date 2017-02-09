ENGLISH_LETTER_FREQ = "etaoinsrhdlucmfywgpbvkxqjz"
VOCABULARY = set()

def get_vocabulary():
    if len(VOCABULARY)==0:
        file = open('words.txt')
        for line in file.readlines():
            VOCABULARY.add(line)

    return VOCABULARY


def get_index_from_char(c):
    return ord(c) - ord('a')


def get_char_from_index(i):
    return chr(i + ord('a'))


def get_frequency(text):
    char_map = [(get_char_from_index(i), 0) for i in range(26)]

    for c in text:
        index = get_index_from_char(c)
        char_map[index] = (c, char_map[index][1] + 1)

    char_map.sort(cmp=lambda a, b: b[1] - a[1])
    return [c[0] for c in char_map]


def decipher(cipher_text, key):
    return "".join([get_char_from_index(key.index(c)) for c in cipher_text])


COMBINATIONS_CACHE = {}

def get_combinations(plain_text):
    if plain_text in COMBINATIONS_CACHE:
        return COMBINATIONS_CACHE[plain_text]
    if len(plain_text) == 1:
        return [[plain_text]]
    combinations = []
    for i in xrange(1, len(plain_text)+1):
        first_word = plain_text[:i]
        rest = plain_text[i:]
        if len(rest) == 0:
            combinations.append([first_word])
        else:
            right_combinations = get_combinations(rest)
            for comb in right_combinations:
                comb.insert(0, first_word)
            combinations += right_combinations

    COMBINATIONS_CACHE[plain_text] = combinations
    return combinations


def calculate_score(words):
    dictionary_words_count = 0
    for word in words:
        if word in get_vocabulary():
            dictionary_words_count += 1
    return dictionary_words_count/len(words)


def break_words_calculate_score(plain_text):
    word_combinations = get_combinations(plain_text)
    score = 0
    for combination in word_combinations:
        current_score = calculate_score(combination)
        if current_score > score:
            score = current_score
    return score


def find_key(cipher_text):
    cipher_text = cipher_text.lower()
    cipher_freq = get_frequency(cipher_text)
    key_list = ['' for c in range(26)]

    i = 0
    for c in ENGLISH_LETTER_FREQ:
        key_list[get_index_from_char(c)] = cipher_freq[i]
        i += 1

    plain_text = decipher(cipher_text, key_list)
    prv_score = break_words_calculate_score(plain_text)

    return prv_score


if __name__ == '__main__':
    cipher = "MXDXBVTZWVMXNSPBQXL"
    plain = find_key(cipher)
    print plain
