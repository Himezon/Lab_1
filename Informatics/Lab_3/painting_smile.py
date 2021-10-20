import pygame
import random

width, height = 320, 300
FPS = 60

ISU = int(input())

def printing_smile(isu):
    eyes = [':', ';', 'X', '8', '=']
    nose = ['-', '<', "-{", "<{"]
    mouth = ['(', ')', 'O', '|', '\\\\', '/', 'P']
    if isu % 7 == 4:
        return (eyes[isu % 5] + nose[isu % 4] + mouth[isu % 7][0])
    return (eyes[isu % 5] + nose[isu % 4] + mouth[isu % 7])

if __name__ == '__main__':
    pygame.init()
    size = width, height
    pygame.display.set_caption('Смайлик')
    screen = pygame.display.set_mode(size)
    screen.fill((0, 0, 128))
    running = True
    clock = pygame.time.Clock()
    font = pygame.font.Font(None, 280)
    emoji = font.render(f'{printing_smile(ISU)}', True,
                        (255, 255, 255))

    while running:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                running = False
            if (event.type == pygame.MOUSEBUTTONDOWN) or (event.type == pygame.KEYDOWN and event.key == pygame.K_SPACE):
                emoji = font.render(f'{printing_smile(ISU)}', True,
                                    (random.randint(0, 255), random.randint(0, 255), random.randint(0, 255)))
        screen.blit(emoji, (32, 32))
        clock.tick(FPS)
        pygame.display.flip()

    pygame.quit()
